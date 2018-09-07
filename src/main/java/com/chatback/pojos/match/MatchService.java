package com.chatback.pojos.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.logging.Logger;

@Service

public class MatchService
{
    @Autowired
    private MatchRepository matchRepository;

    private static List<Match> members = Collections.synchronizedList( new ArrayList<>());
    private static String guis = null;


    public static Match getMatch(Match match)
    {
        Match matchCompletableFuture = getMatchCompletableFuture(match);
        Logger.getAnonymousLogger().info("has matched for " + match.getSelf());
        return matchCompletableFuture;
    }

    private static Match getMatchCompletableFuture(Match match)
    {
        addToList(match);
        Match match1 = null;
        Executor executor = Executors.newFixedThreadPool(5);
        match1 = getMatch(match, executor);
        return match1;
    }

    private static void addToList(Match match)
    {
        boolean present = members.stream().filter(x -> x.getSelf().equalsIgnoreCase(match.getSelf())).findFirst().isPresent();
        if(!present)
        {
            members.add(match);
        }
    }

    private static Match getMatch(Match match, Executor executor)
    {
        Match match1 = null;
        CompletableFuture<Match> completableFuture = getAttempting_match(match, executor);
        try
        {
            match1 = completableFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return match1;
    }

    public static void removeMatch(Match match)
    {
        Executor executor = Executors.newFixedThreadPool(5);
        Match partner = members.stream().filter(x -> x.getSelf().equalsIgnoreCase(match.getPartner())).findFirst().get();
        CompletableFuture<Match> completableFuture = getAttemptingRemoval(match, executor);
        CompletableFuture<Match> completableFuture2 = getAttemptingRemoval(partner, executor);
        try
        {
            completableFuture.get();
            completableFuture2.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static CompletableFuture<Match> getAttempting_match(Match match, Executor executor)
    {

        return new CompletableFuture<>().supplyAsync(new Supplier<Match>() {
                                                        @Override
                                                        public Match get()
                                                        {

                                                            while(!match.isMatched())
                                                            {
                                                                try
                                                                {
                                                                    TimeUnit.MILLISECONDS.sleep(15);
                                                                    Logger.getAnonymousLogger().info("attempting match for " + match.getSelf());
                                                                    members.stream().forEachOrdered(x->Logger.getAnonymousLogger().info("matches in member list " + x.getSelf()));
                                                                    getMember(match);

                                                                }
                                                                catch (Exception e)
                                                                {
                                                                    Logger.getAnonymousLogger().info(e.getLocalizedMessage());
                                                                }
                                                            }
                                                            return match; }}, executor);
    }

    private static CompletableFuture<Match> getAttemptingRemoval(Match match, Executor executor)
    {
        return new CompletableFuture<>().supplyAsync(new Supplier<Match>() {
            @Override
            public Match get()
            {
                while(getMembers().contains(match))
                {
                    Match partner = getMembers().stream().filter(x -> x.getSelf().equalsIgnoreCase(x.getPartner())).findFirst().orElse(null);
                    if(partner == null || partner.isMatched())
                    {
                        try
                        {
                            TimeUnit.MILLISECONDS.sleep(2);
                            Logger.getAnonymousLogger().info("attempting removal after successful match for " + match.getSelf());
                            removePairFromList(match);
                        } catch (Exception e) {
                            Logger.getAnonymousLogger().info(e.getLocalizedMessage());
                        }
                    }
                }
                return match; }}, executor);
    }

    private static Match getMember(Match match) {

        Match partner = null;
        while(partner == null && match.getPartner() ==null)
        {
            partner = getMembers().stream().filter(x -> !x.getSelf().equalsIgnoreCase(match.getSelf())).findFirst().orElse(null);
        }
        if(guis == null)
        {
            guis = getGUIS();
        }
        if(match.isMatched() == false || partner.isMatched() == false)
        {
            settingValues(match, partner, guis);
        }
        guis = null;
        return match;
    }

    private static void removePairFromList(Match match)
    {
        Iterator<Match> iterator = getMembers().iterator();
        while(iterator.hasNext())
        {
            if(iterator.next() == match)
            {
                iterator.remove();
            }
        }
    }

    private static synchronized void settingValues(Match match, Match match1, String guis)
    {
        match.setPartner(match1.getSelf());
        match1.setPartner(match.getSelf());

        List<String> guisList = new ArrayList<>();
        guisList.add(match.getConversation());
        guisList.add(match1.getConversation());

        String guiPlace = guisList.stream().filter(x->x!=null).findFirst().orElse(null);
        if(guiPlace == null)
        {
            match.setConversation(guis);
            match1.setConversation(guis);
        }
        else
        {
            match.setConversation(guis);
            match1.setConversation(guis);
        }
        match.setMatched(true);
        match1.setMatched(true);
    }

    public static String getGUIS()
    {
            // Creating a random UUID (Universally unique identifier).
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();

            return randomUUIDString;
    }

    private synchronized static List<Match> getMembers()
    {
        return members;
    }
}

package com.chatback.pojos.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.logging.Logger;

@Service

public class MatchService
{
    @Autowired
    private MatchRepository matchRepository;


   private static List<Match> members = new ArrayList<>();
    private static String guis = null;


    public static Match getMatch(Match match)
    {
        Match matchCompletableFuture = getMatchCompletableFuture(match);
        Logger.getAnonymousLogger().info("has matched");
        return matchCompletableFuture;
    }

    private static Match getMatchCompletableFuture(Match match)
    {
        members.add(match);
        Match match1 = null;
        Executor executor = Executors.newFixedThreadPool(5);
        match1 = getMatch(match, executor);
        removeMatch(match, executor);
        return match1;
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

    private static void removeMatch(Match match, Executor executor)
    {
        CompletableFuture<Match> completableFuture = getAttemptingRemoval(match, executor);
        try
        {
            completableFuture.get();
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
                                                            Match member =null;
                                                            while(member == null)
                                                            {
                                                                try
                                                                {
                                                                    TimeUnit.SECONDS.sleep(2);
                                                                    Logger.getAnonymousLogger().info("attempting match");
                                                                    member = getMember(match);
                                                                }
                                                                catch (Exception e)
                                                                {
                                                                    throw new IllegalStateException(e);
                                                                }
                                                            }
                                                            return member; }}, executor);
    }

    private static CompletableFuture<Match> getAttemptingRemoval(Match match, Executor executor)
    {
        return new CompletableFuture<>().supplyAsync(new Supplier<Match>() {
            @Override
            public Match get()
            {
                Match member =null;
                while(member == null)
                {
                    try
                    {
                        TimeUnit.SECONDS.sleep(2);
                        Logger.getAnonymousLogger().info("attempting remaoval after successful match");
                        removePairFromList(match);
                    }
                    catch (Exception e)
                    {
                        throw new IllegalStateException(e);
                    }
                }
                return member; }}, executor);
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
        settingValues(match, partner, guis);
        guis = null;
        return match;
    }

    private static void removePairFromList(Match match)
    {
        getMembers().remove(match);
    }

    private static void settingValues(Match match, Match match1, String guis)
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

package com.chatback.pojos.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service

public class MatchService
{
    @Autowired
    private MatchRepository matchRepository;


   private  static List<Match> members = new ArrayList<>();
    private static Executor executor;
    private static String guis=null;


    public static Match getMatch(Match match)
    {
        Match matchCompletableFuture = getMatchCompletableFuture(match, MatchService::getMember);
        Logger.getAnonymousLogger().info("has matched");
        return matchCompletableFuture;
    }

    private static Match getMatchCompletableFuture(Match match, Function<Match,Match> function) {
        members.add(match);
        Match match1 = null;
        executor = Executors.newFixedThreadPool(10);
        CompletableFuture<Match> completableFuture = new CompletableFuture<>().supplyAsync(new Supplier<Match>()
                                                                                                                    {
                                                                                                                        @Override
                                                                                                                        public Match get()
                                                                                                                        {
                                                                                                                            Match member =null;
                                                                                                                            while(member == null)
                                                                                                                            {
                                                                                                                                try {
                                                                                                                                    TimeUnit.SECONDS.sleep(3);

                                                                                                                                    Logger.getAnonymousLogger().info("attempting match");
                                                                                                                                    member = getMember(match);
                                                                                                                                } catch (Exception e) {
                                                                                                                                    throw new IllegalStateException(e);
                                                                                                                                }
                                                                                                                            }
                                                                                                                            return member;
                                                                                                                        }
                                                                                                                    }, executor);
        try
        {
             match1 = completableFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        removePairFromList(match);
        return match1;
    }

    private static synchronized Match getMember(Match match)
    {
        Match partner = null;
        while(partner == null && match.getPartner()==null)
        {
            partner = members.stream().filter(x -> !x.getSelf().equalsIgnoreCase(match.getSelf())).findFirst().orElse(null);

        }
        if(guis == null)
        {
            guis = getGUIS();
        }
        settingValues(match, partner, guis);
        guis = null;
        return match;
    }

    private static void removePairFromList(Match match1)
    {
        members = members.stream().filter(x->x!=match1).collect(Collectors.toList());
    }

    private static void settingValues(Match match, Match match1, String guis) {
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

}

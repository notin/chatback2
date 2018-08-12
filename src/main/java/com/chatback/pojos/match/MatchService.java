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

@Service

public class MatchService
{
    @Autowired
    private MatchRepository matchRepository;


   private  static List<Match> members = new ArrayList<>();


    public static Match getMatch(Match match)
    {
        return getMatchCompletableFuture(match, MatchService::getMember);

    }

    private static Match getMatchCompletableFuture(Match match, Function<Match,Match> function) {
        members.add(match);
        Match match1 = null;
        Executor executor = Executors.newFixedThreadPool(10);
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
        return match1;
    }

    private static Match getMember(Match match) {

        Match match1 = null;
        while(match1 == null)
        {
            match1 = members.stream().filter(x -> !x.getSelf().equalsIgnoreCase(match.getSelf())).findFirst().orElse(null);

        }
        String guis = getGUIS();
        settingValues(match, match1, guis);
        return match;
    }

    private static void settingValues(Match match, Match match1, String guis) {
        match.setPartner(match1.getSelf());
        match1.setPartner(match.getSelf());
        if(match.getConversation() == null)
        {
            match.setConversation(guis);
        }
        if(match.getConversation() == null)
        {
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

package com.chatback;


import com.chatback.controllers.MatchController;
import com.chatback.pojos.match.Match;
import com.chatback.pojos.match.MatchService;
import com.chatback.utils.Caller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.FileAssert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	MatchController matcher;
	@Autowired
	MatchService service;
	@Test
	public void contextLoads()
	{
		Caller caller = new Caller();
		Object object =caller.makeCall("localhost:8080", null, null, HttpMethod.GET, Object.class, null);
		object.equals("");
	}

	List<Match> matchList = new ArrayList<>();
	List<Match> returns = new ArrayList<>();
	@Test
	public void BVT_match()
	{
		Match match1 = Match.builder().build();
		match1.setSelf("match1");

		Match match2 = Match.builder().build();
		match2.setSelf("match2");

		matchList.add(match1);
		matchList.add(match2);

		try
        {

            ExecutorService executor = Executors.newFixedThreadPool(5);
            runCall(executor).thenRun();

        }
		catch (Exception e)
        {
            fail("Didnt match");
        }
	}

	private CompletableFuture<Match> makeCall(Match match, ExecutorService executor)
    {
        return new CompletableFuture<>().supplyAsync(new Supplier<Match>()
                                                        {
                                                            @Override
                                                            public Match get()
                                                            {
                                                             return matcher.requestMatch(match);
                                                            };
                                                        }, executor);
    }

	private CompletableFuture<Void> runCall(ExecutorService executor)
	{
		return new CompletableFuture<>().runAsync(new Runnable()
		{

			@Override
			public void run()
			{
				 matchList.stream().forEachOrdered(x->returns.add(matcher.requestMatch(x)));
			};
		}, executor);
	}

}

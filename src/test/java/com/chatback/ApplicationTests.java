package com.chatback;


import com.chatback.utils.Caller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads()
	{
		Caller caller = new Caller();
		Object object =caller.makeCall("localhost:8080", null, null, HttpMethod.GET, Object.class, null);
		object.equals("");
	}

}

package com.chatback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.logging.Logger;

@SpringBootApplication
@ComponentScan(basePackages = "com.chatback")
public class Application
{
	public static void main(String[] args)
	{
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
		configurableApplicationContext.getEnvironment().getSystemProperties().keySet().stream().forEachOrdered(x->Logger.getAnonymousLogger().info(x));
	}
}

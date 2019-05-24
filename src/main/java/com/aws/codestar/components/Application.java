package com.aws.codestar.components;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.")
public class Application
{
	public static void main(String[] args)
	{
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
	}
}

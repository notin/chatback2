package start;

import controllers.Messager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pojos.converation.Conversation;

import java.util.logging.Logger;

@SpringBootApplication
public class start
{
    public static void main(String[] args)
    {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(start.class, args);
        Logger.getAnonymousLogger().info(String.valueOf(configurableApplicationContext.getStartupDate()));
    }
}

package start;

import controllers.Messager;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pojos.converation.Conversation;
@SpringBootApplication
public class start
{
    public static void main(String[] args)
    {
        Messager messager = new Messager();
        messager.receive(new Conversation());
    }
}

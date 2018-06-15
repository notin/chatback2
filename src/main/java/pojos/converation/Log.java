package pojos.converation;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class Log{

	@JsonProperty("messages")
	private List<MessagesItem> messages;

	public void setMessages(List<MessagesItem> messages){
		this.messages = messages;
	}

	public List<MessagesItem> getMessages(){
		return messages;
	}

	@Override
 	public String toString(){
		return 
			"Log{" + 
			"messages = '" + messages + '\'' + 
			"}";
		}
}
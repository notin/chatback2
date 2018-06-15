package pojos.converation;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class Conversation{

	@JsonProperty("conversation")
	private Conversation conversation;

	@JsonProperty("log")
	private Log log;

	@JsonProperty("endtime")
	private int endtime;

	@JsonProperty("responses")
	private List<ResponsesItem> responses;

	@JsonProperty("id")
	private int id;

	@JsonProperty("starttime")
	private int starttime;

	public void setConversation(Conversation conversation){
		this.conversation = conversation;
	}

	public Conversation getConversation(){
		return conversation;
	}

	public void setLog(Log log){
		this.log = log;
	}

	public Log getLog(){
		return log;
	}

	public void setEndtime(int endtime){
		this.endtime = endtime;
	}

	public int getEndtime(){
		return endtime;
	}

	public void setResponses(List<ResponsesItem> responses){
		this.responses = responses;
	}

	public List<ResponsesItem> getResponses(){
		return responses;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setStarttime(int starttime)
	{
		this.starttime = starttime;
	}

	public int getStarttime(){
		return starttime;
	}

	@Override
 	public String toString()
	{
		return 
			"Conversation{" + 
			"conversation = '" + conversation + '\'' + 
			",log = '" + log + '\'' + 
			",endtime = '" + endtime + '\'' + 
			",responses = '" + responses + '\'' + 
			",id = '" + id + '\'' + 
			",starttime = '" + starttime + '\'' + 
			"}";
		}
}
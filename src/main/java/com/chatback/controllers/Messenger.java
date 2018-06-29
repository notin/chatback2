package com.chatback.controllers;

import com.chatback.broker.DatabaseBroker;
import com.chatback.pojos.converation.Conversation;
import com.chatback.pojos.converation.Message;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class Messenger
{
    @RequestMapping(value = "chat", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public void receive(@RequestBody  Conversation conversation)
    {
        String timestamp = String.valueOf(conversation.getMessages().get(0).getTimestamp());
        Logger.getAnonymousLogger().info(timestamp);
        //TODO:Call db
        DatabaseBroker databaseBroker = new DatabaseBroker();
        String from = conversation.getMessages().get(0).getFrom();
        String to = conversation.getMessages().get(0).getTo();
        Message message1 = conversation.getMessages().get(0);
        databaseBroker.setMessages(from, to, message1);

    }
    @RequestMapping(value = "chat", method = RequestMethod.GET)
    public Conversation retrieve(@RequestParam(defaultValue = "1") int index)
    {
        Conversation conversation = getConversation(index);
        return conversation;
    }
    private Conversation getConversation(int index)
    {
        //TODO:Call db
        DatabaseBroker databaseBroker = new DatabaseBroker();
        Message message = databaseBroker.getMessages(index);
        List<Conversation> conversations = new ArrayList<>();

        //TODO:remove stub
        conversations.add(Conversation.builder().id(index)
                        .messages(Collections.singletonList(message))
                        .build());
        Conversation conversation = conversations.stream().filter(x -> x.getId() == index).findFirst().get();
        return conversation;
    }

}

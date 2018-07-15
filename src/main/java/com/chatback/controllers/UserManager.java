package com.chatback.controllers;

import com.chatback.broker.database.DatabaseBroker;
import com.chatback.pojos.converation.Conversation;
import com.chatback.pojos.converation.Message;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserManager
{
    @RequestMapping(value = "chat", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public void create(@RequestBody com.chatback.pojos.User conversation)
    {

        String time = String.valueOf(System.currentTimeMillis());
        Logger.getAnonymousLogger().info(time);
        //TODO:Call db
        DatabaseBroker databaseBroker = new DatabaseBroker();

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

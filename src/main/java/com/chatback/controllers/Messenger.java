package com.chatback.controllers;

import com.chatback.pojos.converation.Conversation;
import com.chatback.pojos.converation.message.Message;
import com.chatback.pojos.converation.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class Messenger extends Controller
{

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "chat", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public void receive(@RequestBody  Conversation conversation)
    {
        List<Message> messages = conversation.getMessage();
        //TODO:Call db

        int index = messages.size()-1;
        messageService.saveMessages(messages.get(index));

    }
    @RequestMapping(value = "chat", method = RequestMethod.GET)
    public Conversation retrieve(@RequestParam(defaultValue = "1") int index)
    {
        Conversation conversation = getConversation(String.valueOf(index));
        return conversation;
    }
    private Conversation getConversation(String index)
    {

        Message message = messageService.findMessage(index);

        //TODO:remove stub
        Conversation conversation = Conversation.builder().id(index)
                .message(Collections.singletonList(message))
                .build();
        return conversation;
    }

}

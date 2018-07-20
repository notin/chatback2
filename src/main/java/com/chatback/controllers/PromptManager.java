package com.chatback.controllers;

import com.chatback.broker.database.DatabaseBroker;
import com.chatback.pojos.converation.Conversation;
import com.chatback.pojos.converation.Message;
import com.chatback.pojos.prompt.Prompts;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class PromptManager
{

    @RequestMapping(value = "propmts", method = RequestMethod.GET)
    public Prompts retrieve()
    {
        Prompts conversation = getConversation();
        return conversation;
    }
    private Prompts getConversation()
    {
        //TODO:Call db
        DatabaseBroker databaseBroker = new DatabaseBroker();
        return databaseBroker.getPropmpts();
    }

}

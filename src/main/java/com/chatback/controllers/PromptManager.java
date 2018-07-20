package com.chatback.controllers;

import com.chatback.broker.database.DatabaseBroker;
import com.chatback.pojos.prompt.Prompt;
import com.chatback.pojos.prompt.Prompts;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PromptManager
{

    @RequestMapping(value = "prompts", method = RequestMethod.GET)
    public Prompts retrieve()
    {
        Prompts conversation = getConversation();
        return conversation;
    }
    private Prompts getConversation()
    {
        //TODO:Call db
        DatabaseBroker databaseBroker = new DatabaseBroker();

        List<Prompt> prompts = databaseBroker.getPrompts();
        Prompts p = Prompts.builder().build();
        p.setPrompt(prompts);
        return p;
    }

}

package com.chatback.pojos.prompt;

import com.chatback.pojos.converation.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromptService
{
    @Autowired
    private PromptRepository promptRepository;

    public Prompt findPromptById(String id)
    {
       return promptRepository.findPromptById(id);
    }

    public Prompt[] getAllPropmts()
    {
        Prompt[] toReturn = null;
        Iterable<Prompt> all = promptRepository.findAll();

        List<Prompt> target = new ArrayList<>();
        all.forEach(target::add);
        toReturn= new Prompt[target.size()-1];
        return  target.toArray(toReturn);
    }

}

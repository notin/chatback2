package com.chatback.pojos.prompt;

import com.chatback.pojos.converation.Conversation;
import com.chatback.pojos.newPropmpts.Pompts2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromptService
{
    @Autowired
    private PromptRepository promptRepository;

    public Pompts2 findPromptById(String id)
    {
       return promptRepository.findPromptById(id);
    }

    public Pompts2[] getAllPropmts()
    {
        Pompts2[] toReturn = null;
        Iterable<Pompts2> all = promptRepository.findAll();

        List<Pompts2> target = new ArrayList<>();
        all.forEach(target::add);
        toReturn= new Pompts2[target.size()-1];
        return  target.toArray(toReturn);
    }

}

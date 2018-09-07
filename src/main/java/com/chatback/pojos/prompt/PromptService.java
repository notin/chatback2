package com.chatback.pojos.prompt;

import com.chatback.pojos.newPropmpts.Prompts2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromptService
{
    @Autowired
    private PromptRepository promptRepository;

    public Prompts2 findPromptById(String id)
    {
       return promptRepository.findPromptById(id);
    }

    public Prompts2[] getAllPropmts()
    {
        Prompts2[] toReturn = null;
        Iterable<Prompts2> all = promptRepository.findAll();

        List<Prompts2> target = new ArrayList<>();
        all.forEach(target::add);
        toReturn= new Prompts2[target.size()-1];
        return  target.toArray(toReturn);
    }

    public void setAllPropmts(List<Prompts2> collect)
    {
        promptRepository.saveAll(collect);
    }

}

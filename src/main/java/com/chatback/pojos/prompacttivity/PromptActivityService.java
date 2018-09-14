package com.chatback.pojos.prompacttivity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromptActivityService
{
    @Autowired
    private PromptActivityRepository repository;

    public PromptActivity findActivitiesByTimeAfter(String id)
    {
       return repository.findActivitiesByTimeAfter(id);
    }

    public PromptActivity findActivitiesById(String id)
    {
        return repository.findActivitiesById(id);
    }

    public void save(PromptActivity activity)
    {
        repository.save(activity);
    }
    public Integer getId()
    {
       return Integer.valueOf((int) repository.count());
    }
}

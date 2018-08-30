package com.chatback.pojos.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService
{
    @Autowired
    private ActivityRepository repository;

    public Activity findActivitiesByTimeAfter(String id)
    {
       return repository.findActivitiesByTimeAfter(id);
    }

    public void save(Activity activity)
    {
        repository.save(activity);
    }
    public Integer getId()
    {
       return Integer.valueOf((int) repository.count());
    }
}

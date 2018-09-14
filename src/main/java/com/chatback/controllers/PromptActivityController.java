package com.chatback.controllers;

import com.chatback.pojos.activity.Activity;
import com.chatback.pojos.prompacttivity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.logging.Logger;

@RestController
public class PromptActivityController extends Controller
{

    @Autowired
    private PromptActivityService promptActivityService;

    @CrossOrigin
    @RequestMapping(value = "promptactivity", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public PromptActivity saveActivity(@RequestBody PromptActivity promptActivity)
    {
        String time = String.valueOf(System.currentTimeMillis());
        Logger.getAnonymousLogger().info(time);
        setTime(promptActivity);
        promptActivityService.save(promptActivity);
        return promptActivityService.findActivitiesById(promptActivity.getId());
    }

    @CrossOrigin
    @RequestMapping(value = "promptactivity", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public PromptActivity getPromptActivity()
    {
        return PromptActivity.builder().build();
    }

//    @CrossOrigin
//    @RequestMapping(value = "activity", method = RequestMethod.GET)
//    public PromptActivity retrieveActivity(@RequestParam(defaultValue = "12") String uid)
//    {
//        String time = String.valueOf(System.currentTimeMillis());
//        Logger.getAnonymousLogger().info(time);
//
//        return promptActivityService.findActivitiesByTimeAfter(uid);
//    }
    private void setId(@RequestBody Activity user)
    {
        if(user.getId()==null)
        {
            String id = String.valueOf(promptActivityService.getId());
            user.setId(id);
        }
    }

    private void setTime(PromptActivity promptActivity)
    {
        if(promptActivity.getTime()==null || promptActivity.getTime().equalsIgnoreCase(""))
        {
            ZonedDateTime pst = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.of("America/Los_Angeles"));
            promptActivity.setTime(pst.toLocalDateTime().toString());
        }
    }
}

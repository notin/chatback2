package com.chatback.controllers;

import com.chatback.pojos.activity.Activity;
import com.chatback.pojos.promptActivity.PromptActivity;
import com.chatback.pojos.promptActivity.PromptActivityService;
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
    public void saveActivity(@RequestBody PromptActivity user)
    {
        String time = String.valueOf(System.currentTimeMillis());
        Logger.getAnonymousLogger().info(time);

        promptActivityService.save(user);
    }

    @CrossOrigin
    @RequestMapping(value = "promptactivity", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public PromptActivity getPromptActivity()
    {
        return PromptActivity.builder().build();
    }

    @CrossOrigin
    @RequestMapping(value = "activity", method = RequestMethod.GET)
    public Activity retrieveActivity(@RequestParam(defaultValue = "12") String uid)
    {
        String time = String.valueOf(System.currentTimeMillis());
        Logger.getAnonymousLogger().info(time);

        return promptActivityService.findActivitiesByTimeAfter(uid);
    }
    private void setId(@RequestBody Activity user)
    {
        if(user.getId()==null)
        {
            String id = String.valueOf(promptActivityService.getId());
            user.setId(id);
        }
    }

    private void setTime(@RequestBody Activity user)
    {
        if(user.getTime()==null)
        {
            ZonedDateTime pst = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.of("PST"));
            user.setTime(pst.toLocalDateTime().toString());
        }
    }
}

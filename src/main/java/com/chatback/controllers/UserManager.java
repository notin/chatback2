package com.chatback.controllers;

import com.chatback.broker.database.DatabaseBroker;
import com.chatback.pojos.User;
import com.chatback.pojos.converation.Conversation;
import com.chatback.pojos.converation.Message;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserManager
{
    @RequestMapping(value = "users", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public void createUser(@RequestBody User user)
    {
        String time = String.valueOf(System.currentTimeMillis());
        Logger.getAnonymousLogger().info(time);
        //TODO:Call db
        DatabaseBroker databaseBroker = new DatabaseBroker();

        databaseBroker.createUserRecord(user);
    }
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public User retrieveUser(@RequestParam(defaultValue = "test") String username)
    {
        String time = String.valueOf(System.currentTimeMillis());
        Logger.getAnonymousLogger().info(time);
        //TODO:Call db
        DatabaseBroker databaseBroker = new DatabaseBroker();
        return databaseBroker.getUserDetails(username);
    }

}

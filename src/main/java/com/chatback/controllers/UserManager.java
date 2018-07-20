package com.chatback.controllers;

import com.chatback.broker.database.DatabaseBroker;
import com.chatback.pojos.user.User;
import org.springframework.web.bind.annotation.*;

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

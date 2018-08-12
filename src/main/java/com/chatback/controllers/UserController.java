package com.chatback.controllers;

import com.chatback.pojos.user.User;
import com.chatback.pojos.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class UserController extends Controller
{

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "users", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public void createUser(@RequestBody User user)
    {
        String time = String.valueOf(System.currentTimeMillis());
        Logger.getAnonymousLogger().info(time);

        userService.saveUser(user);
    }


    @CrossOrigin
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public User retrieveUser(@RequestParam(defaultValue = "12") String uid)
    {
        String time = String.valueOf(System.currentTimeMillis());
        Logger.getAnonymousLogger().info(time);

        return userService.findUserByUId(uid);
    }
}

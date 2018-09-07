package com.chatback.controllers;

import com.chatback.pojos.newPropmpts.Prompts2;
import com.chatback.pojos.prompt.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromptController extends Controller
{
    @Autowired
    PromptService promptService;

    @CrossOrigin
    @RequestMapping(value = "prompts", method = RequestMethod.GET)
    public Prompts2[] retrieve()
    {
        Prompts2[] allPropmts = promptService.getAllPropmts();
        return allPropmts;
    }

}

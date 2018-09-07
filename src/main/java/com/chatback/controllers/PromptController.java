package com.chatback.controllers;

import com.chatback.pojos.newPropmpts.Prompts2;
import com.chatback.pojos.prompt.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    @CrossOrigin
    @RequestMapping(value = "prompts", method = RequestMethod.POST)
    public void set(@RequestBody Prompts2[] prompts2s)
    {
        promptService.setAllPropmts(Arrays.stream(prompts2s).collect(Collectors.toList()));
    }



}

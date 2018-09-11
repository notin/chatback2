package com.chatback.controllers;

import com.chatback.pojos.newPropmpts.ActionsItem;
import com.chatback.pojos.newPropmpts.Id;
import com.chatback.pojos.newPropmpts.Prompts2;
import com.chatback.pojos.prompt.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
//        List<Id> collect = Arrays.stream(prompts2s).collect(Collectors.toList());
//        setIds(collect);
//
//        List<Id> collectMain = Arrays.stream(prompts2s).collect(Collectors.toList()).stream().map(x->x.getMain()).filter(x->x!=null).collect(Collectors.toList());
//        setIds(collectMain);
//
//        List<Id> collectResponse = Arrays.stream(prompts2s).collect(Collectors.toList()).stream().map(x->x.getResponse()).filter(x->x!=null).collect(Collectors.toList());
//        setIds(collectResponse);
//
//        List<ActionsItem[]> collect1 = Arrays.stream(prompts2s).collect(Collectors.toList()).stream().map(x -> x.getResponse()).filter(x->x!=null).collect(Collectors.toList()).stream().map(x -> x.getActions()).collect(Collectors.toList());
//
//
//        List<Prompts2> pompts2List = Arrays.stream(prompts2s).collect(Collectors.toList());
        List<Prompts2> toSend = Arrays.stream(prompts2s).collect(Collectors.toList());
        promptService.setAllPropmts(toSend);
    }

    private void setIds(@RequestParam List<Id> pompts2s) {
        int endExclusive = pompts2s.size();
        IntStream.range(0, endExclusive).forEachOrdered(x->pompts2s.get(x).setId(String.valueOf(x)));
    }


}

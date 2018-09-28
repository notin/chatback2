package com.chatback.controllers;

import com.chatback.pojos.newPropmpts.*;
import com.chatback.pojos.prompt.ActionItemService;
import com.chatback.pojos.prompt.MainService;
import com.chatback.pojos.prompt.PromptService;
import com.chatback.pojos.prompt.ResponsePromptService;
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

    @Autowired
    MainService mainService;

    @Autowired
    ResponsePromptService responsePromptService;

    @Autowired
    ActionItemService actionItemService;

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


        List<Main> collectMain = Arrays.stream(prompts2s).collect(Collectors.toList()).stream().map(x->x.getMain()).filter(x->x!=null).collect(Collectors.toList());

        List<ResponsePrompt> collectResponse = Arrays.stream(prompts2s).collect(Collectors.toList()).stream().map(x->x.getResponse()).filter(x->x!=null).collect(Collectors.toList());
        collectMain.addAll(collectResponse.stream().map(x->x.getMain()).collect(Collectors.toList()));

        collectResponse.stream().forEachOrdered(x->System.out.println(x));
        collectMain.stream().forEachOrdered(x->System.out.println(x));

//
        List<ActionsItem[]> actionsItems = Arrays.stream(prompts2s).collect(Collectors.toList()).stream().map(x -> x.getResponse()).filter(x->x!=null).collect(Collectors.toList()).stream().map(x -> x.getActions()).collect(Collectors.toList());

        actionItemService.setAllResponse(actionsItems);
        mainService.setAllMains(collectMain);
        responsePromptService.setAllResponse(collectResponse);

//
        List<Prompts2> pompts2List = Arrays.stream(prompts2s).collect(Collectors.toList());
        List<Prompts2> toSend = Arrays.stream(prompts2s).collect(Collectors.toList());
        toSend.stream().forEachOrdered(x->System.out.println(x.toString()));
        promptService.setAllPropmts(toSend);

    }

    private void setIds(@RequestParam List<Id> pompts2s) {
        int endExclusive = pompts2s.size();
        IntStream.range(0, endExclusive).forEachOrdered(x->pompts2s.get(x).setId(String.valueOf(x)));
    }


}

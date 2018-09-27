package com.chatback.pojos.prompt;

import com.chatback.pojos.newPropmpts.ActionsItem;
import com.chatback.pojos.newPropmpts.ResponsePrompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActionItemService
{
    @Autowired
    private ActionItemRepository actionItemService;

//    public Main findPromptById(String id)
//    {
//       return actionItemService.findPromptById(id);
//    }

//    public Main getAllPropmts()
//    {
//        Main[] toReturn = null;
//        Iterable<Main> all = actionItemService.findAll();
//
//        List<Prompts2> target = new ArrayList<>();
//        all.forEach(target::add);
//        toReturn= new Main[target.size()-1];
//        return  target.toArray(toReturn);
//    }

    public void setAllResponse(List<ActionsItem[]> collect)
    {
        for(ActionsItem[] f : collect)
        {
            actionItemService.saveAll(Arrays.stream(f).collect(Collectors.toList()));
        }
    }

}

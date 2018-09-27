package com.chatback.pojos.prompt;

import com.chatback.pojos.newPropmpts.Main;
import com.chatback.pojos.newPropmpts.ResponsePrompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsePromptService
{
    @Autowired
    private ResponsePromptsRepository responsePromptService;

//    public Main findPromptById(String id)
//    {
//       return responsePromptService.findPromptById(id);
//    }

//    public Main getAllPropmts()
//    {
//        Main[] toReturn = null;
//        Iterable<Main> all = responsePromptService.findAll();
//
//        List<Prompts2> target = new ArrayList<>();
//        all.forEach(target::add);
//        toReturn= new Main[target.size()-1];
//        return  target.toArray(toReturn);
//    }

    public void setAllResponse(List<ResponsePrompt> collect)
    {
        responsePromptService.saveAll(collect);
    }

}

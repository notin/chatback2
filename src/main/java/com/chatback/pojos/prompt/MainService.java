package com.chatback.pojos.prompt;

import com.chatback.pojos.newPropmpts.Main;
import com.chatback.pojos.newPropmpts.Prompts2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService
{
    @Autowired
    private MainRepository mainRepository;

//    public Main findPromptById(String id)
//    {
//       return mainRepository.findPromptById(id);
//    }

//    public Main getAllPropmts()
//    {
//        Main[] toReturn = null;
//        Iterable<Main> all = mainRepository.findAll();
//
//        List<Prompts2> target = new ArrayList<>();
//        all.forEach(target::add);
//        toReturn= new Main[target.size()-1];
//        return  target.toArray(toReturn);
//    }

    public void setAllMains(List<Main> collect)
    {
        mainRepository.saveAll(collect);
    }

}

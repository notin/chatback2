package com.aws.codestar.components.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObitService
{
    @Autowired
    private ObitRepository obitRepository;

    public Obit findObit(String id)
    {
       return obitRepository.findMessageById(id);
    }

    public void saveMessages(Obit obit)
    {
        obitRepository.save(obit);
    }
}

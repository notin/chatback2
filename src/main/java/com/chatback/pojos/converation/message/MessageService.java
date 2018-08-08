package com.chatback.pojos.converation.message;

import com.chatback.pojos.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService
{
    @Autowired
    private MessageRepository messageRepository;

    public Message findMessage(String id)
    {
       return messageRepository.findMessageById(id);
    }

    public void saveMessages(Message message)
    {
        messageRepository.save(message);
    }
}

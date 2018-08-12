package com.chatback.pojos.converation;

import com.chatback.pojos.converation.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService
{
    @Autowired
    private ConversationRepository messageRepository;

    public Conversation findConversations(String id)
    {
       return messageRepository.findMessageById(id);
    }

    public void saveMessages(Conversation message)
    {
        messageRepository.save(message);
    }
}

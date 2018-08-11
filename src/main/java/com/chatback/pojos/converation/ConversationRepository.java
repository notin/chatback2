package com.chatback.pojos.converation;


import com.chatback.pojos.converation.message.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ConversationRepository extends CrudRepository<Conversation, Long>
{
     Conversation findMessageById(String uid);
}

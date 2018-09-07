package com.chatback.pojos.prompt;


import com.chatback.pojos.converation.Conversation;
import com.chatback.pojos.newPropmpts.Pompts2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PromptRepository extends CrudRepository<Pompts2, Long>
{
     Pompts2 findPromptById(String uid);
}

package com.chatback.pojos.prompt;


import com.chatback.pojos.converation.Conversation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PromptRepository extends CrudRepository<Prompt, Long>
{
     Prompt findPromptById(String uid);
}

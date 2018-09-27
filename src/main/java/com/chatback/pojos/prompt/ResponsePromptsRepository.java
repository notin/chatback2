package com.chatback.pojos.prompt;


import com.chatback.pojos.newPropmpts.Prompts2;
import com.chatback.pojos.newPropmpts.ResponsePrompt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ResponsePromptsRepository extends CrudRepository<ResponsePrompt, Long>
{
     Prompts2 findPromptById(String uid);

}

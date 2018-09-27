package com.chatback.pojos.prompt;


import com.chatback.pojos.newPropmpts.Main;
import com.chatback.pojos.newPropmpts.Prompts2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MainRepository extends CrudRepository<Main, Long>
{
     Prompts2 findPromptById(String uid);

}

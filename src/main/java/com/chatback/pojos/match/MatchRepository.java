package com.chatback.pojos.match;


import com.chatback.pojos.converation.message.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MatchRepository extends CrudRepository<Message, Long>
{
     Match findMessageById(String uid);
}

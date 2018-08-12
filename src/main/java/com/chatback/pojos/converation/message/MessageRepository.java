package com.chatback.pojos.converation.message;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MessageRepository extends CrudRepository<Message, Long>
{
     Message findMessageById(String uid);
}

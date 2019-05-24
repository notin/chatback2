package com.aws.codestar.components.pojo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ObitRepository extends CrudRepository<Obit, Long>
{
     Obit findMessageById(String uid);
}

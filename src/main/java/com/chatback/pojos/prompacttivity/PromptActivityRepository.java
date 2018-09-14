package com.chatback.pojos.prompacttivity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PromptActivityRepository extends CrudRepository<PromptActivity, Long>
{
     PromptActivity findActivitiesByTimeAfter(String uid);
     PromptActivity findActivitiesByTimeBefore(String uid);

     PromptActivity findActivitiesById(String uid);
}

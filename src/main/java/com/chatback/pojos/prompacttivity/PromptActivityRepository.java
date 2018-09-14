package com.chatback.pojos.prompacttivity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PromptActivityRepository extends CrudRepository<PropmptActivity, Long>
{
     PropmptActivity findActivitiesByTimeAfter(String uid);
     PropmptActivity findActivitiesByTimeBefore(String uid);
}

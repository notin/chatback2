package com.chatback.pojos.activity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ActivityRepository extends CrudRepository<Activity, Long>
{
     Activity findActivitiesByTimeAfter(String uid);
     Activity findActivitiesByTimeBefore(String uid);
}

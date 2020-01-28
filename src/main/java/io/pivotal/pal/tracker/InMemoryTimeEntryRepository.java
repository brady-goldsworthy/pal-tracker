package io.pivotal.pal.tracker;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryTimeEntryRepository {

    Map<Long, TimeEntry> repo = new HashMap<>();
    private Long counter = 1L;


    public TimeEntry create(TimeEntry time)
    {
        time.setId(counter++);
        repo.put(time.getId(), time);
        return time;
    }

    public TimeEntry find(long id)
    {
        return repo.get(id);
    }

    public TimeEntry update(long id, TimeEntry time)
    {
         time.setId(id);
         if(repo.replace(id, time) == null){
             return null;
         }
         else{
             return time;
         }

    }

    public void delete(long id)
    {
        repo.remove(id);
    }

    public List<TimeEntry> list()
    {
        return new ArrayList<TimeEntry>(repo.values());
    }




}

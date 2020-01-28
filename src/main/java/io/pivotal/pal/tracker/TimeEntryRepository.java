package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TimeEntryRepository {

    @Autowired
    InMemoryTimeEntryRepository inMemoryTimeEntryRepository;

    public TimeEntry create (TimeEntry timeEntry)
    {
        return inMemoryTimeEntryRepository.create(timeEntry);
    }
    public TimeEntry update (long id, TimeEntry timeEntry)
    {
        return inMemoryTimeEntryRepository.update(id, timeEntry);
    }
    public void delete (long id)
    {
        inMemoryTimeEntryRepository.delete(id);
    }
    public List<TimeEntry> list()
    {
        return inMemoryTimeEntryRepository.list();
    }
    public TimeEntry find(long id)
    {
        return inMemoryTimeEntryRepository.find(id);

    }


}

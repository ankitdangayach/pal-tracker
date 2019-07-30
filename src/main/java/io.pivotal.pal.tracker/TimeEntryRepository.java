package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry timeEntry);
    public TimeEntry find(long timeEntryId);
    public List list();
    public void delete(long id);
    public TimeEntry update(long id, TimeEntry timeEntry);
}

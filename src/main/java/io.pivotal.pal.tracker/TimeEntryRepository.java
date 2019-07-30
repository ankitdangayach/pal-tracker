package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry timeEntry);
    public TimeEntry find(Long timeEntryId);
    public List list();
    public void delete(Long id);
    public TimeEntry update(Long id, TimeEntry timeEntry);
}

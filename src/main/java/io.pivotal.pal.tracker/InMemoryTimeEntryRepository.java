package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.*;

public class InMemoryTimeEntryRepository  implements TimeEntryRepository{

    Map<Long, TimeEntry> dataMap = new HashMap<Long, TimeEntry>();
    private long sequenceNumber = 0l;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        /*Set<Long> keyset = dataMap.keySet();
        Long maxId = 0l;
        for(Iterator<Long> itr = keyset.iterator(); itr.hasNext();) {
            Long currentId = itr.next();
            if(currentId > maxId) {
                maxId = currentId;
            }
        }
        maxId = maxId + 1;*/
        sequenceNumber++;
        timeEntry.setId(sequenceNumber);
        dataMap.put(sequenceNumber, timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {

        return dataMap.get(timeEntryId);
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(null == dataMap.get(id)) {
            return null;
        }
        TimeEntry timeEntrySaved = dataMap.get(id);
        timeEntrySaved.setUserId(timeEntry.getUserId());
        timeEntrySaved.setProjectId(timeEntry.getProjectId());
        timeEntrySaved.setDate(timeEntry.getDate());
        timeEntrySaved.setHours(timeEntry.getHours());
        dataMap.put(id, timeEntrySaved);
        return timeEntrySaved;
    }

    @Override
    public void delete(long id) {

        dataMap.remove(id);
    }

    @Override
    public List list() {

        return new ArrayList(dataMap.values());
    }
}

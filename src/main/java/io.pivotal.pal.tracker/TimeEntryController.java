package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry resTimeEntry = timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<>(resTimeEntry, HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable(name="id") long timeEntryId) {
        TimeEntry resTimeEntry = timeEntryRepository.find(timeEntryId);
        if(null == resTimeEntry) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(resTimeEntry, HttpStatus.OK);
        }

    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable(name="id") long timeEntryId, @RequestBody TimeEntry expected) {
        TimeEntry resTimeEntry = timeEntryRepository.update(timeEntryId, expected);
        if(null == resTimeEntry) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(resTimeEntry, HttpStatus.OK);
        }


    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity delete(@PathVariable(name="id") long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public TimeEntryRepository getTimeEntryRepository() {
        return timeEntryRepository;
    }

    public void setTimeEntryRepository(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }
}

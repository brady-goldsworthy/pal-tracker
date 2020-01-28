package io.pivotal.pal.tracker;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
public class TimeEntryController {
    TimeEntryRepository timeEntryRepository;

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create (@RequestBody TimeEntry timeEntry)
    {
        return new ResponseEntity<>(timeEntryRepository.create(timeEntry), HttpStatus.CREATED);
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> update (@PathVariable long id, @RequestBody TimeEntry timeEntry)
    {
        TimeEntry entry = timeEntryRepository.update(id, timeEntry);

        if (entry == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(entry);
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity delete (@PathVariable long id)
    {
        timeEntryRepository.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list()
    {
        return ResponseEntity.ok().body(timeEntryRepository.list());
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id)
    {
        TimeEntry entry = timeEntryRepository.find(id);

        if (entry == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(entry);
    }
}

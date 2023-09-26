package com.example.studycenter.web.resource;

import com.example.studycenter.dto.TimeTable;
import com.example.studycenter.repository.TimeTableRepository;
import com.example.studycenter.service.TimeTableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timeTable")
public class TimeTableResource {
    private final TimeTableService timeTableService;
    private final TimeTableRepository timeTableRepository;

    public TimeTableResource(TimeTableService timeTableService, TimeTableRepository timeTableRepository) {
        this.timeTableService = timeTableService;
        this.timeTableRepository = timeTableRepository;
    }


    @PostMapping()
    public ResponseEntity<TimeTable> create(@RequestBody TimeTable timeTableDTO){
        TimeTable timeTable = timeTableService.save(timeTableDTO);
        return ResponseEntity.ok(timeTable);
    }

    @PutMapping()
    public ResponseEntity<TimeTable> update(@RequestBody TimeTable timeTableDTO){
        TimeTable timeTable = timeTableService.save(timeTableDTO);
        return ResponseEntity.ok(timeTable);
    }

    @GetMapping()
    public ResponseEntity<List<TimeTable>> getAll(){
        List<TimeTable> timeTableList = timeTableService.findAll();
        return ResponseEntity.ok(timeTableList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TimeTable> getTimeTableDetails(@PathVariable Long id){
        if (!timeTableRepository.existsById(id)){
            throw new RuntimeException("no information found");
        }
        TimeTable timeTable = timeTableService.getTimeTableDetail(id);
        return ResponseEntity.ok(timeTable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if (!timeTableRepository.existsById(id)){
            throw new RuntimeException("data not found");
        }
        timeTableService.delete(id);
        return ResponseEntity.ok("data deleted");
    }
}

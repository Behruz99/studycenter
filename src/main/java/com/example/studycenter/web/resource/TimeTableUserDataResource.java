package com.example.studycenter.web.resource;

import com.example.studycenter.dto.TimeTableUserData;
import com.example.studycenter.repository.TimeTableUserDataRepository;
import com.example.studycenter.service.TimeTableUserDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timeTableUserData")
public class TimeTableUserDataResource {
    private final TimeTableUserDataService timeTableUserDataService;
    private final TimeTableUserDataRepository timeTableUserDataRepository;

    public TimeTableUserDataResource(TimeTableUserDataService timeTableUserDataService, TimeTableUserDataRepository timeTableUserDataRepository) {
        this.timeTableUserDataService = timeTableUserDataService;
        this.timeTableUserDataRepository = timeTableUserDataRepository;
    }


    @PostMapping()
    public ResponseEntity<TimeTableUserData> create(@RequestBody TimeTableUserData timeTableUserDataDTO){
        TimeTableUserData timeTableUserData = timeTableUserDataService.save(timeTableUserDataDTO);
        return ResponseEntity.ok(timeTableUserData);
    }

    @PutMapping()
    public ResponseEntity<TimeTableUserData> update(@RequestBody TimeTableUserData timeTableUserDataDTO){
        TimeTableUserData timeTableUserData = timeTableUserDataService.save(timeTableUserDataDTO);
        return ResponseEntity.ok(timeTableUserData);
    }

    @GetMapping()
    public ResponseEntity<List<TimeTableUserData>> getAll(){
        List<TimeTableUserData> timeTableUserDataList = timeTableUserDataService.findAll();
        return ResponseEntity.ok(timeTableUserDataList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TimeTableUserData> getTimeTableUserDataDetails(@PathVariable Long id){
        if (!timeTableUserDataRepository.existsById(id)){
            throw new RuntimeException("no information found");
        }
        TimeTableUserData timeTableUserData = timeTableUserDataService.getTimeTableUserDataDetail(id);
        return ResponseEntity.ok(timeTableUserData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if (!timeTableUserDataRepository.existsById(id)){
            throw new RuntimeException("data not found");
        }
        timeTableUserDataService.delete(id);
        return ResponseEntity.ok("data deleted");
    }
}

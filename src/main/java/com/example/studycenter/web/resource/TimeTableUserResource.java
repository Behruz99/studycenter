package com.example.studycenter.web.resource;

import com.example.studycenter.dto.TimeTableUser;
import com.example.studycenter.repository.TimeTableUserRepository;
import com.example.studycenter.service.TimeTableUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timeTableUser")
public class TimeTableUserResource {
    private final TimeTableUserService timeTableUserService;
    private final TimeTableUserRepository timeTableUserRepository;

    public TimeTableUserResource(TimeTableUserService timeTableUserService, TimeTableUserRepository timeTableUserRepository) {
        this.timeTableUserService = timeTableUserService;
        this.timeTableUserRepository = timeTableUserRepository;
    }


    @PostMapping()
    public ResponseEntity<TimeTableUser> create(@RequestBody TimeTableUser timeTableUserDTO){
        TimeTableUser timeTableUser = timeTableUserService.save(timeTableUserDTO);
        return ResponseEntity.ok(timeTableUser);
    }

    @PutMapping()
    public ResponseEntity<TimeTableUser> update(@RequestBody TimeTableUser timeTableUserDTO){
        TimeTableUser timeTableUser = timeTableUserService.save(timeTableUserDTO);
        return ResponseEntity.ok(timeTableUser);
    }

    @GetMapping()
    public ResponseEntity<List<TimeTableUser>> getAll(){
        List<TimeTableUser> timeTableUsersList = timeTableUserService.findAll();
        return ResponseEntity.ok(timeTableUsersList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TimeTableUser> getTimeTableUserDetails(@PathVariable Long id){
        if (!timeTableUserRepository.existsById(id)){
            throw new RuntimeException("no information found");
        }
        TimeTableUser timeTableUser = timeTableUserService.getTimeTableUserDetail(id);
        return ResponseEntity.ok(timeTableUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if (!timeTableUserRepository.existsById(id)){
            throw new RuntimeException("data not found");
        }
        timeTableUserService.delete(id);
        return ResponseEntity.ok("data deleted");
    }
}

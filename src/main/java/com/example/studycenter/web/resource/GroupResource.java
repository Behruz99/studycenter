package com.example.studycenter.web.resource;

import com.example.studycenter.dto.Group;
import com.example.studycenter.repository.GroupRepository;
import com.example.studycenter.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupResource {
    private final GroupService groupService;
    private final GroupRepository groupRepository;

    public GroupResource(GroupService groupService, GroupRepository groupRepository) {
        this.groupService = groupService;
        this.groupRepository = groupRepository;
    }


    @PostMapping()
    public ResponseEntity<Group> create(@RequestBody Group groupDTO){
        Group group = groupService.save(groupDTO);
        return ResponseEntity.ok(group);
    }

    @PutMapping()
    public ResponseEntity<Group> update(@RequestBody Group groupDTO){
        Group group = groupService.save(groupDTO);
        return ResponseEntity.ok(group);
    }

    @GetMapping()
    public ResponseEntity<List<Group>> getAll(){
        List<Group> groupList = groupService.findAll();
        return ResponseEntity.ok(groupList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupDetails(@PathVariable Long id){
        if (!groupRepository.existsById(id)){
            throw new RuntimeException("no information found");
        }
        Group group = groupService.getGroupDetail(id);
        return ResponseEntity.ok(group);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if (!groupRepository.existsById(id)){
            throw new RuntimeException("data not found");
        }
        groupService.delete(id);
        return ResponseEntity.ok("data deleted");
    }
}

package com.example.studycenter.service;

import com.example.studycenter.dto.Group;
import com.example.studycenter.model.MGroup;
import com.example.studycenter.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
    public  Group save(Group groupDTO){
        MGroup group = groupDTO.getId() != null ? groupRepository.getReferenceById(groupDTO.getId()): null;
        if (group == null){
            group = new MGroup();
        }
        group.setName(groupDTO.getName());
        groupRepository.save(group);
        return group.groupTO();
    }
    public List<Group> findAll(){
        List<Group> result = new ArrayList<>();
        List<MGroup> groups = groupRepository.findAll();
        if (!CollectionUtils.isEmpty(groups)){
            for (MGroup group : groups){
                result.add(group.groupTO());
            }
        }
        return result;
    }
    public void delete(Long id){
        groupRepository.deleteById(id);
    }
    public Group getGroupDetail(Long id){
        MGroup group = groupRepository.getReferenceById(id);
        return group.groupTO();
    }
}

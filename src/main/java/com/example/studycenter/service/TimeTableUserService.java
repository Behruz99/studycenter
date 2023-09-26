package com.example.studycenter.service;

import com.example.studycenter.dto.TimeTableUser;
import com.example.studycenter.model.MTimeTableUser;
import com.example.studycenter.repository.TimeTableUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeTableUserService {
    private final TimeTableUserRepository timeTableUserRepository;

    public TimeTableUserService(TimeTableUserRepository timeTableUserRepository) {
        this.timeTableUserRepository = timeTableUserRepository;
    }
    public TimeTableUser save(TimeTableUser timeTableUserDTO){
        MTimeTableUser timeTableUser = timeTableUserDTO.getId() != null ? timeTableUserRepository.getReferenceById(timeTableUserDTO.getId()): null;
        if (timeTableUser == null){
            timeTableUser = new MTimeTableUser();
        }
        timeTableUser.setUser(timeTableUserDTO.getUser());
        timeTableUser.setTimeTable(timeTableUserDTO.getTimeTable());
        timeTableUserRepository.save(timeTableUser);
        return timeTableUser.timeTableUserTO();
    }
    public List<TimeTableUser> findAll(){
        List<TimeTableUser> result = new ArrayList<>();
        List<MTimeTableUser> timeTableUsers = timeTableUserRepository.findAll();
        if (!CollectionUtils.isEmpty(timeTableUsers)){
            for (MTimeTableUser timeTableUser1 : timeTableUsers){
                result.add(timeTableUser1.timeTableUserTO());
            }
        }
        return result;
    }
    public void delete(Long id){
        timeTableUserRepository.deleteById(id);
    }
    public TimeTableUser getTimeTableUserDetail(Long id){
        MTimeTableUser timeTableUser = timeTableUserRepository.getReferenceById(id);
        return timeTableUser.timeTableUserTO();
    }
}

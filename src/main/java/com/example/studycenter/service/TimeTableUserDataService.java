package com.example.studycenter.service;

import com.example.studycenter.dto.TimeTableUserData;
import com.example.studycenter.model.MTimeTableUserData;
import com.example.studycenter.repository.TimeTableUserDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeTableUserDataService {
    private final TimeTableUserDataRepository timeTableUserDataRepository;

    public TimeTableUserDataService(TimeTableUserDataRepository timeTableUserDataRepository) {
        this.timeTableUserDataRepository = timeTableUserDataRepository;
    }
    public TimeTableUserData save(TimeTableUserData timeTableUserDataDTO){
        MTimeTableUserData timeTableUserData = timeTableUserDataDTO.getId() != null ? timeTableUserDataRepository.getReferenceById(timeTableUserDataDTO.getId()): null;
        if (timeTableUserData == null){
            timeTableUserData = new MTimeTableUserData();
        }
        timeTableUserData.setTimeTableUser(timeTableUserDataDTO.getTimeTableUser());
        timeTableUserData.setHomeworkgrade(timeTableUserDataDTO.getHomeworkgrade());
        timeTableUserData.setLessongrade(timeTableUserDataDTO.getLessongrade());
        timeTableUserData.setAttendance(timeTableUserDataDTO.getAttendance());
        timeTableUserDataRepository.save(timeTableUserData);
        return timeTableUserData.timeTableUserDataTO();
    }
    public List<TimeTableUserData> findAll(){
        List<TimeTableUserData> result = new ArrayList<>();
        List<MTimeTableUserData> timeTableUserData = timeTableUserDataRepository.findAll();
        if (!CollectionUtils.isEmpty(timeTableUserData)){
            for (MTimeTableUserData timeTableUserData1 : timeTableUserData){
                result.add(timeTableUserData1.timeTableUserDataTO());
            }
        }
        return result;
    }
    public void delete(Long id){
        timeTableUserDataRepository.deleteById(id);
    }
    public TimeTableUserData getTimeTableUserDataDetail(Long id){
        MTimeTableUserData timeTableUserData = timeTableUserDataRepository.getReferenceById(id);
        return timeTableUserData.timeTableUserDataTO();
    }
}

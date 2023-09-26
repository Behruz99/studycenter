package com.example.studycenter.service;

import com.example.studycenter.dto.TimeTable;
import com.example.studycenter.model.MTimeTable;
import com.example.studycenter.repository.TimeTableRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeTableService {
    private final TimeTableRepository timeTableRepository;

    public TimeTableService(TimeTableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }
    public TimeTable save(TimeTable timeTableDTO){
        MTimeTable timeTable = timeTableDTO.getId() != null ? timeTableRepository.getReferenceById(timeTableDTO.getId()): null;
        if (timeTable == null){
            timeTable = new MTimeTable();
        }
        timeTable.setName(timeTableDTO.getName());
        timeTable.setIsStart(timeTableDTO.getIsStart());
        timeTable.setStartDate(timeTableDTO.getStartDate());
        timeTable.setEndDate(timeTableDTO.getEndDate());
        timeTable.setGroup(timeTable.getGroup());
        timeTableRepository.save(timeTable);
        return timeTable.timeTableTO();
    }
    public List<TimeTable> findAll(){
        List<TimeTable> result = new ArrayList<>();
        List<MTimeTable> timeTables = timeTableRepository.findAll();
        if (!CollectionUtils.isEmpty(timeTables)){
            for (MTimeTable timeTable1 : timeTables){
                result.add(timeTable1.timeTableTO());
            }
        }
        return result;
    }
    public void delete(Long id){
        timeTableRepository.deleteById(id);
    }
    public TimeTable getTimeTableDetail(Long id){
        MTimeTable timeTable = timeTableRepository.getReferenceById(id);
        return timeTable.timeTableTO();
    }
}

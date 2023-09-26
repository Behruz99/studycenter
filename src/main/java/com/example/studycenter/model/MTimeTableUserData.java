package com.example.studycenter.model;

import com.example.studycenter.dto.TimeTableUserData;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "time_table_user_data")
@Getter
@Setter
public class MTimeTableUserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private MTimeTableUser timeTableUser;
    private String homeworkgrade;
    private String lessongrade;
    private String attendance;
    public TimeTableUserData timeTableUserDataTO(){
        TimeTableUserData timeTableUserData = new TimeTableUserData();
        timeTableUserData.setId(getId());
        timeTableUserData.setTimeTableUser(getTimeTableUser());
        timeTableUserData.setHomeworkgrade(getHomeworkgrade());
        timeTableUserData.setLessongrade(getLessongrade());
        timeTableUserData.setAttendance(getAttendance());
        return timeTableUserData;
    }
}

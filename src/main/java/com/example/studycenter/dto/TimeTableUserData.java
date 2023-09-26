package com.example.studycenter.dto;

import com.example.studycenter.model.MTimeTableUser;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TimeTableUserData {
    private Long id;
    private MTimeTableUser timeTableUser;
    private String homeworkgrade;
    private String lessongrade;
    private String attendance;
}

package com.example.studycenter.dto;


import com.example.studycenter.domin.Users;
import com.example.studycenter.model.MTimeTable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeTableUser {
    private Long id;
    private Users user;
    private MTimeTable timeTable;
}

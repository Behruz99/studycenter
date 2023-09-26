package com.example.studycenter.dto;

import com.example.studycenter.model.MGroup;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TimeTable {
    private Long id;
    private String name;
    private String isStart;
    private String startDate;
    private String endDate;
    private MGroup group;
}

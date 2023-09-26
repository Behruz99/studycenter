package com.example.studycenter.model;

import com.example.studycenter.dto.TimeTable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "time_table")
@Getter
@Setter
public class MTimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "is_start")
    private String isStart;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;

    @ManyToOne
    private MGroup group;

    public TimeTable timeTableTO() {
        TimeTable timeTable = new TimeTable();
        timeTable.setId(getId());
        timeTable.setName(getName());
        timeTable.setIsStart(getIsStart());
        timeTable.setStartDate(getStartDate());
        timeTable.setEndDate(getEndDate());
        timeTable.setGroup(getGroup());
        return timeTable;
    }
}

package com.example.studycenter.model;

import com.example.studycenter.domin.Users;
import com.example.studycenter.dto.TimeTableUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "time_table_user")
@Getter
@Setter
public class MTimeTableUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Users user;
    @ManyToOne
    private MTimeTable timeTable;

    public TimeTableUser timeTableUserTO() {
        TimeTableUser timeTableUser = new TimeTableUser();
        timeTableUser.setId(getId());
        timeTableUser.setUser(getUser());
        timeTableUser.setTimeTable(getTimeTable());
        return timeTableUser;
    }
}

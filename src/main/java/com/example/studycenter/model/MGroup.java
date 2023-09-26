package com.example.studycenter.model;

import com.example.studycenter.dto.Group;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = ("groups"))
@Getter
@Setter
public class MGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    public Group groupTO() {
        Group group = new Group();
        group.setId(getId());
        group.setName(getName());
        return group;
    }
}

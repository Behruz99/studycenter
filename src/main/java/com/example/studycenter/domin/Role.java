package com.example.studycenter.domin;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Role implements Serializable {
    @Id
    @NotNull
    private String name;
}

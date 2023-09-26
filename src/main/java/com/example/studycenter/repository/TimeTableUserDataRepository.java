package com.example.studycenter.repository;

import com.example.studycenter.model.MTimeTableUserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeTableUserDataRepository extends JpaRepository<MTimeTableUserData, Long> {
        }

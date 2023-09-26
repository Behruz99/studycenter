package com.example.studycenter.repository;

import com.example.studycenter.model.MTimeTableUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeTableUserRepository extends JpaRepository<MTimeTableUser, Long> {
}

package com.example.studycenter.repository;

import com.example.studycenter.model.MTimeTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeTableRepository extends JpaRepository<MTimeTable, Long> {
}

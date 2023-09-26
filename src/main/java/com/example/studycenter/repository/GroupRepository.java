package com.example.studycenter.repository;

import com.example.studycenter.model.MGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<MGroup, Long> {
}

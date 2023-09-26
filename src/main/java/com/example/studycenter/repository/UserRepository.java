package com.example.studycenter.repository;

import com.example.studycenter.domin.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUserName(String userUser);
    @Query("select u from Users u where u.userName=:userName")
    Users findByLogin(@Param("userName") String userName);


    boolean existsByUserName(String userName);
}

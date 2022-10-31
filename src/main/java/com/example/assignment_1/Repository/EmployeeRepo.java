package com.example.assignment_1.Repository;

import com.example.assignment_1.DTO.EmployeeDTO;
import com.example.assignment_1.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Integer> {

    @Query(value = "SELECT * FROM EmployeeEntity WHERE id = ?1",nativeQuery = true) //1 --> 1st argument
    EmployeeEntity getUserByUserId(String empID);
}

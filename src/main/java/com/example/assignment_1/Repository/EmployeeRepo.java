package com.example.assignment_1.Repository;

import com.example.assignment_1.DTO.EmployeeDTO;
import com.example.assignment_1.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Integer> {

    @Query(value = "SELECT * FROM employee_entity WHERE id = ?1",nativeQuery = true)
    EmployeeEntity getUserByUserId(String id);

}

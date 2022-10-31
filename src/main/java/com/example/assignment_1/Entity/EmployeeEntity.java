package com.example.assignment_1.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  //Can give a custom name to the table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeEntity {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String designation;
    private String department;
    private String contactNumber;
    private String gender;
    private String address;


}

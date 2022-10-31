package com.example.assignment_1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String designation;
    private String department;
    private String contactNumber;
    private String gender;
    private String address;
}

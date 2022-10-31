package com.example.assignment_1.Controller;

import com.example.assignment_1.DTO.EmployeeDTO;
import com.example.assignment_1.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;

@RestController
@RequestMapping("/api/employeeDetails")
@CrossOrigin

public class EmployeeDetails {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/viewAllDetails")
    public List<EmployeeDTO> viewAllDetails(){
        return employeeService.getAllEmployees();
    }

    //Select a user by ID
    //Select * from EmployeeEntity where id = 2
    @GetMapping("/viewEmployeeById/{empID}")
    public EmployeeDTO viewEmployeeByID(@PathVariable String empID){
        return employeeService.getEmployeeById(empID);
    }

    @PostMapping("/saveDetails")
    public EmployeeDTO saveDetails(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.saveEmployee(employeeDTO) ;
    }

    @PutMapping("/updateDetails")
    public EmployeeDTO updateDetails(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(employeeDTO) ;
    }

    @DeleteMapping("/deleteDetails") //Delete details by giving all user data
    public boolean deleteDetails(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.deleteUser(employeeDTO);
    }

}

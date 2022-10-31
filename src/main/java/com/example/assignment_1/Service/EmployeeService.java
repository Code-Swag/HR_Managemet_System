package com.example.assignment_1.Service;

import com.example.assignment_1.DTO.EmployeeDTO;
import com.example.assignment_1.Entity.EmployeeEntity;
import com.example.assignment_1.Repository.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    //save employee
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){
        employeeRepo.save(modelMapper.map(employeeDTO, EmployeeEntity.class));
        return employeeDTO; //return the same type to frontend
    }

    //view all employees
    public List<EmployeeDTO> getAllEmployees(){
        List<EmployeeEntity> employees = employeeRepo.findAll();
        return modelMapper.map(employees, new TypeToken<List<EmployeeDTO>>(){}.getType());
    }

    //update an employee
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO){
        employeeRepo.save(modelMapper.map(employeeDTO, EmployeeEntity.class));
        return employeeDTO;
    }

    //delete an employee
    public boolean deleteUser (EmployeeDTO employeeDTO){
        employeeRepo.delete(modelMapper.map(employeeDTO, EmployeeEntity.class));
        return true;
    }

    //Select * from EmployeeEntity where id = 2
    public EmployeeDTO getEmployeeById(String empID){
        EmployeeEntity employee=employeeRepo.getUserByUserId(empID);
        return modelMapper.map(employee,EmployeeDTO.class);
    }



}

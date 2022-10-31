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

    //Select * from EmployeeEntity where id =
    public EmployeeDTO getEmployeeById(String id){
        EmployeeEntity employee=employeeRepo.getUserByUserId(id);
        return modelMapper.map(employee,EmployeeDTO.class);
    }

    //update an employee
    public EmployeeDTO updateAllEmployee(EmployeeDTO employeeDTO){
        employeeRepo.save(modelMapper.map(employeeDTO, EmployeeEntity.class));
        return employeeDTO;
    }

    //update an employee by id
    public EmployeeDTO updateEmployee(String id,EmployeeDTO employeeDTO){

        EmployeeEntity employeeEntity = employeeRepo.getById(Integer.valueOf(id));

        employeeEntity.setFirstName(employeeDTO.getFirstName());
        employeeEntity.setFirstName(employeeDTO.getFirstName());
        employeeEntity.setLastName(employeeDTO.getLastName());
        employeeEntity.setAddress(employeeDTO.getAddress());
        employeeEntity.setDepartment(employeeDTO.getDepartment());
        employeeEntity.setDesignation(employeeDTO.getDesignation());
        employeeEntity.setGender(employeeDTO.getGender());
        employeeEntity.setContactNumber(employeeDTO.getContactNumber());

        employeeRepo.save(employeeEntity);

        return employeeDTO;
    }

    //delete an employee
    public boolean deleteUser (String id){

            EmployeeEntity employeeEntity = employeeRepo.getById(Integer.valueOf(id));
            employeeRepo.delete(employeeEntity);

            return true;

    }

}

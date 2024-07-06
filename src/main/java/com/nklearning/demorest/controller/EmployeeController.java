package com.nklearning.demorest.controller;


import com.nklearning.demorest.exception.ResourceNotFoundException;
import com.nklearning.demorest.model.Employee;
import com.nklearning.demorest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }


    //Build Get emp by ID
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id" + id));
        return  ResponseEntity.ok(employee);
    }

    //Build update emp by ID
     @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee UpdateEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist to update with id:"+id));
        UpdateEmployee.setFirstName(employeeDetails.getFirstName());
        UpdateEmployee.setLastName((employeeDetails.getLastName()));
        UpdateEmployee.setEmail((employeeDetails.getEmail()));
        employeeRepository.save(UpdateEmployee);
        return ResponseEntity.ok(UpdateEmployee);
     }
}

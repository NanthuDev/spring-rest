package com.nklearning.demorest.repository;

import com.nklearning.demorest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //All Crud Operations

}

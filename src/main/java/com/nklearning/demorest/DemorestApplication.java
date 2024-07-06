package com.nklearning.demorest;

import com.nklearning.demorest.model.Employee;
import com.nklearning.demorest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemorestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemorestApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public  void run(String... args){
		Employee employee= new Employee();
		employee.setFirstName("Nantha");
		employee.setLastName("Kumar");
		employee.setEmail("test@g.com");
		employeeRepository.save(employee);
	}

}

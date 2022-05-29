package com.example.Employee_Management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Employee_Management.repository.Employeerepository;
import com.example.Employee_Management.model.Employee;


@SpringBootApplication
public class EmployeeManagementApplication {

	private static final Logger log = LoggerFactory.getLogger(EmployeeManagementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadDatabase(Employeerepository repository) {
		return (args) -> {

			repository.save(new Employee("Bhargavi", "Manager", 100000));
			repository.save(new Employee("Vaishnavi", "HR", 50000));
			repository.save(new Employee("KiranMayee", "Trainee", 25000));
			repository.save(new Employee("Shruthi", "Programmer", 25000));

			log.info("All Employees");
			log.info("-------------------------------");
			for (Employee employee : repository.findAll()) {
				log.info(employee.toString());
			}

			Employee employee = repository.findById(1L);
			log.info("Employee found with findById(1L):");
			log.info("--------------------------------");
			log.info(employee.toString());
		};
	}

}
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

			repository.save(new Employee("John", "Manager", 200000));
			repository.save(new Employee("Meera", "Team LeadLead", 50000));
			repository.save(new Employee("Dora", "HR", 20000));
			repository.save(new Employee("Sofia", "Programmer", 45000));
			repository.save(new Employee("Tara", "Traniee",35000));
			

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
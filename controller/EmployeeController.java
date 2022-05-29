package com.example.Employee_Management.controller;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Employee_Management.exception.EmployeeExistedException;
import com.example.Employee_Management.exception.ResourceNotFoundException;
import com.example.Employee_Management.model.Employee;
import com.example.Employee_Management.repository.Employeerepository;

public class EmployeeController {
	private Employeerepository employeerepository;

    public EmployeeController(Employeerepository employeerepository) {
        this.employeerepository = employeerepository;
    }
    
//new employee to be added if employee already existed otherwise throws exception
    
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        if (employeerepository.existsById(newEmployee.getId()))
            throw new EmployeeExistedException();
        else return employeerepository.save(newEmployee);
    }

    //get all employees based on their salary in descending order
    // if salary is same get based on their name in ascending order
    
    @GetMapping("/employees")
    Iterable<Employee> getAllEmployees() {
        return employeerepository.findAll(Sort.by(Sort.Order.desc("salary"), Sort.Order.asc("name")));
    }

//get the employee by id
    
    @GetMapping("/employees/{id}")
    Employee getEmployee(@PathVariable Long id) {
        return employeerepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

//Update an employee salary as path variable
//* @return returns ok response with updated salary otherwise returns ResourceNotFoundException
     
    @PutMapping("/employees/{id}/{salary}")
    ResponseEntity<Employee> updateSalary(@PathVariable long id, @PathVariable int salary) {
        Employee employee = getEmployee(id);
        employee.setSalary(salary);
        employeerepository.save(employee);
        return ResponseEntity.ok(employee);
    }
    //delete the employee
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeerepository.deleteById(id);
    }
}

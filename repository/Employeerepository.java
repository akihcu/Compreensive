package com.example.Employee_Management.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.Employee_Management.model.Employee;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface Employeerepository extends PagingAndSortingRepository<Employee, Long> {
    Employee findById(long id);
}
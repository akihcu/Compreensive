package com.example.Employee_Management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Salary")
	private long salary;
	
	@Column(name="Designation")
	private String designation;
	
	protected Employee() {}

	public Employee( String name,String designation,long salary) {
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}
	

	@Override
	    public String toString() {
	        return "Employee{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", designation='" + designation + '\'' +
	                ", salary=" + salary +
	                '}';
	    }
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	

}

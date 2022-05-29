package com.example.Employee_Management.exception;

public class EmployeeExistedException extends RuntimeException {

		public EmployeeExistedException() {
	        super("Employee already existed in database");
	}

	}



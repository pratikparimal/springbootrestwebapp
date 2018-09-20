package com.springbootrestwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrestwebapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	

}

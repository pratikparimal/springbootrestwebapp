package com.springbootrestwebapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrestwebapp.model.Employee;
import com.springbootrestwebapp.repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	/* save an employee */
	
	public Employee insertEmp(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	/* search all employee */
	
	public List<Employee> selectAllEmp(){
		return employeeRepository.findAll();
	}
	
	
	/* get an employee */
	
	public Employee selectOneEmp(Long empId){
		return employeeRepository.findOne(empId);
	}
	
	
	/* delete an employee */
	
	public void deleteEmp(Employee emp) {
		employeeRepository.delete(emp);
	}

}

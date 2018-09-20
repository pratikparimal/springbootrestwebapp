package com.springbootrestwebapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestwebapp.dao.EmployeeDAO;
import com.springbootrestwebapp.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	/* to select an employee from database */
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp ) {
		return employeeDAO.insertEmp(emp);
	}
	
	/* get all employee */
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeDAO.selectAllEmp();
	}
	
	/* get all employee by Id */
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable(value="id") Long empId){
		
		Employee emp = employeeDAO.selectOneEmp(empId);
		if(emp==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	/* update an employee by empId */
	@PutMapping("/emloyee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empId, @Valid @RequestBody Employee empDetails){
		
		Employee emp = employeeDAO.selectOneEmp(empId);
		if(emp==null){
			return ResponseEntity.notFound().build();
		}
		
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());
		
		Employee updateEmployee = employeeDAO.insertEmp(emp);
		
		return ResponseEntity.ok().body(updateEmployee);
	}
	
	/* delete an employee */
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empId){
		
		Employee emp = employeeDAO.selectOneEmp(empId);
		if(emp==null){
			return ResponseEntity.notFound().build();
		}
		
		employeeDAO.deleteEmp(emp);
		return ResponseEntity.ok().build();
	}
	
}

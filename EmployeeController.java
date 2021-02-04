package com.springboot.crudrestfulwebservices.controller;

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

import com.springboot.crudrestfulwebservices.exception.ResourceNotFoundException;
import com.springboot.crudrestfulwebservices.model.Employee;
import com.springboot.crudrestfulwebservices.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1") 
public class EmployeeController {
	
//autowire the EmployeeRepository class
@Autowired
private EmployeeRepository employeeRepository;

//create restful web services

//create - get all employees 
@GetMapping("/employees") 
public List<Employee> getAllEmployees(){
	return employeeRepository.findAll(); //returns all the employees list in table
}

//create employee
@PostMapping("/employees")
public Employee createEmployee(@Valid @RequestBody Employee employee) {
	return employeeRepository.save(employee); //returns the employee record which we have saved
}

//get employee by id 
@GetMapping("employees/{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") long employeeId) throws ResourceNotFoundException{
	Employee employee =  employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id:" +employeeId));
	 return ResponseEntity.ok().body(employee); //returns the employee record with the corresponding id in table, if not exception
}

//update employee by id
@PutMapping("/employees/{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") long employeeId, @RequestBody Employee employeeDetails) throws ResourceNotFoundException{
	Employee employee =  employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id:" +employeeId));
    employee.setFirstName(employeeDetails.getFirstName());
    employee.setLastName(employeeDetails.getLastName());
    employee.setEmailid(employeeDetails.getEmailid());
    employeeRepository.save(employee);
    return ResponseEntity.ok().body(employee); //returns the updated employee record with the corresponding id in table, if not exception
}

//delete employee by id
@DeleteMapping("/employees/{id}")
public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") long employeeId)throws ResourceNotFoundException {
	employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id:" +employeeId));
	employeeRepository.deleteById(employeeId);
	return ResponseEntity.ok().build();  //returns the deleted employee record with the corresponding id in table, if not exception
}
	
}

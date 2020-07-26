package com.kta.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kta.springboot.cruddemo.entity.Employee;
import com.kta.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	
	@Autowired 
	private EmployeeService service;
	// quick and dirty: inject employee dao
		
	// expose "/employees" endpoint and return list of employees
	@GetMapping("/employees")
	public List<Employee> getAll() {
		return service.getAll();
	}

	// expose "/employees/{id}" endpoint and return employee object by id
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee employee = service.findById(id);
		if (employee == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		return employee;
	}
	
	// expose "/employees" endpoint and post the list
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		service.save(employee);
		return employee;
	}
	
	// add mapping for PUT/employees - update existing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		service.save(employee);
		return employee;
	}
	
	// add mapping for DELETE /employees/{id} for delete employee
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		Employee tempEmployee = service.findById(id);
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		service.deleteById(id);
		return "Deleted employee id - " + id;
	}
}

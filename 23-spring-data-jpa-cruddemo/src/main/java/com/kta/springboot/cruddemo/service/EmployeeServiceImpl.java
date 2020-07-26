package com.kta.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kta.springboot.cruddemo.dao.EmployeeRespository;
import com.kta.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRespository employeeRepo;
	
	@Override
	public List<Employee> getAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepo.findById(theId);
		
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepo.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepo.deleteById(theId);
	}

}

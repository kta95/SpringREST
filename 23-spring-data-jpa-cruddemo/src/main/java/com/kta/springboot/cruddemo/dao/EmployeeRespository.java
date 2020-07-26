package com.kta.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kta.springboot.cruddemo.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}

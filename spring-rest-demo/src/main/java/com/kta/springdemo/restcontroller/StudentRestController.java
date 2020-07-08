package com.kta.springdemo.restcontroller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kta.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	
	// define "PostConstruct" to load student data only once
	
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Kyaw Thet", "Aung"));
		theStudents.add(new Student("Thant Phyo", "Aung"));
		theStudents.add(new Student("Arkar", "Hein"));		
	}
	
	// define end point for "/students" - return student list
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		return theStudents;		
	}
	
	// define endpoint for pathVariable "/students/{studentId}"
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// check the studentID against list size
		if((studentId >= theStudents.size() || studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	// Add an exception handler using @ExceptionHandler
	

}












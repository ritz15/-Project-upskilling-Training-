package com.example.RestAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestAPI.bean.Student;

@RestController
@RequestMapping("students")
public class StudentController {

	//http://localhost:8080/student
	
	@GetMapping("student")
	public ResponseEntity<Student> getStudent() {
		Student student= new Student(1,"Pragathi","Vadigeri");
//		return new ResponseEntity<Student>(student,HttpStatus.OK);
//		return ResponseEntity.ok(student);
		return ResponseEntity.ok().header("custom-header", "pragathi")
				.body(student);
		
	}
	
	//http://localhost:8080/students
	@GetMapping
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> student = new ArrayList<>();
		student.add(new Student(1,"Pragathi","vadigeri"));
		student.add(new Student(2,"Sahana","manvi"));
		student.add(new Student(3,"suhas","manvi"));
		student.add(new Student(4,"varsha","machnur"));
		return ResponseEntity.ok(student);
		
	}
	//Spring boot REST API with PathVariale
	//{id} is URI template variable 
	//http://localhost:8080/students/1
	@GetMapping("{id}/{first-name}/{last-name}")
	public ResponseEntity<Student> StudentPathVariable(@PathVariable("id") int studentId,
										@PathVariable("first-name") String firstName,
										@PathVariable("last-name") String lastName) {
		Student student=new Student(studentId,firstName, lastName);
		return ResponseEntity.ok(student);
	}
	
	
	//SpringBoot REST API with Request Param
	//http://localhost:8080/students/query?id=1&firstName=Pragathi&lastName=Vadigeri
	
	@GetMapping("query")
	public ResponseEntity<Student> StudentQueryVariable(@RequestParam int id,
										@RequestParam String firstName,
										@RequestParam String lastName) {
		Student student = new Student(id,firstName,lastName);
		return ResponseEntity.ok(student);
	}
	
	//http://localhost:8080/students/create
	@PostMapping("create")
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return new ResponseEntity<Student>(student,HttpStatus.CREATED);
	}
	
	//http://localhost:8080/students/3/update
	@PutMapping("{id}/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,
			@PathVariable("id") int studentId) {
		
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return ResponseEntity.ok(student);
	}
	
	//http://localhost:8080/3/delete
	@DeleteMapping("{id}/delete")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
		System.out.println(studentId);
		return ResponseEntity.ok("Student deleted successfully");
	}
	
}

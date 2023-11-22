package com.student_task.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student_task.demo.entity.Student;
import com.student_task.demo.service.StudentService;


@RestController
public class StudentController {

	@Autowired
	private StudentService studentServ;
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudent( @RequestBody  Student student){  
	 Student s = studentServ.addStudent(student);
	return  new ResponseEntity<Student>(s,HttpStatus.CREATED);
	}
    
	@GetMapping("/allStudents")
	public ResponseEntity <List<Student> >getstudents(){
		List<Student> studentList =studentServ.getAllStudents();
		return  new ResponseEntity <List<Student>> (studentList,HttpStatus.OK);
		
	}
	@PutMapping("/user/{id}")
	public ResponseEntity<Void> update(  @PathVariable int id ,@RequestBody Student student)  {
		studentServ.update(id,student);
		return  new ResponseEntity<>(HttpStatus.OK);
	} 
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String> delete (@PathVariable ("id") int id)  {
		studentServ.deleteById(id);
		//return "Deleted";
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}  
}

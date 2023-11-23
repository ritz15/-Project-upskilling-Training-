package com.student_task.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student_task.demo.entity.Student;
import com.student_task.demo.service.StudentService;
import com.student_task.exception.StudentAlreadyExistsException;
import com.student_task.exception.StudentDoesntExistException;



@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentServ;
	
	@PostMapping("/add")
	public ResponseEntity<Student> addStudent( @RequestBody  Student student) {  
	 Student s = studentServ.addStudent(student);
	return  new ResponseEntity<Student>(s,HttpStatus.CREATED);
	}
    
	@GetMapping("/")
	public ResponseEntity <List<Student> >getstudents(){
		List<Student> studentList =studentServ.getAllStudents();
		return  new ResponseEntity <List<Student>> (studentList,HttpStatus.OK);
		
	}
	@GetMapping ("/get/{id}")
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable int id) {
		//return Optional.of(userServ.getUserById(id));
		
	Optional<Student> userObj=studentServ.getStudentById(id);
		return  new ResponseEntity <Optional<Student>> ( userObj,HttpStatus.OK);
		
	} 
	@PutMapping("/update/{id}")
	public ResponseEntity<Void> update(  @PathVariable int id ,@RequestBody Student student) {
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

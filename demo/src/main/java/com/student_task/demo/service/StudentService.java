package com.student_task.demo.service;

import java.util.List;
import java.util.Optional;

import com.student_task.demo.entity.Student;
import com.student_task.exception.StudentDoesntExistException;

public interface StudentService {

	Student addStudent(Student student) ;

	List<Student> getAllStudents();

	void update(int id, Student student); 

	void deleteById(int id);

	Optional<Student> getStudentById(int id) ;

}

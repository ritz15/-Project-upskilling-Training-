package com.student_task.demo.service;

import java.util.List;

import com.student_task.demo.entity.Student;

public interface StudentService {

	Student addStudent(Student student);

	List<Student> getAllStudents();

	void update(int id, Student student);

	void deleteById(int id);

}

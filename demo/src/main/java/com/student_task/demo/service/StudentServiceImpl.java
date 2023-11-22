package com.student_task.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_task.demo.entity.Student;
import com.student_task.demo.repo.StudentRepo;

@Service
public class StudentServiceImpl  implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		Student addedStudent = studentRepo.save(student);
		return addedStudent;

	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return (List<Student>) studentRepo.findAll();

	}

	@Override
	public void update(int id, Student student) {
		// TODO Auto-generated method stub
		studentRepo.save(student);
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(id);
	}
	

}

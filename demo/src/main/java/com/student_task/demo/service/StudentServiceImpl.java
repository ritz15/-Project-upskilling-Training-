package com.student_task.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_task.demo.entity.Student;
import com.student_task.demo.repo.StudentRepo;
import com.student_task.exception.StudentAlreadyExistsException;

@Service
public class StudentServiceImpl  implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student addStudent(Student student)  {
		// TODO Auto-generated method stub
	/*	if(studentRepo.existsById(student.getId()))
			throw new StudentAlreadyExistsException(); */
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
		
		/*Student st = studentRepo.findById(id).orElseThrow(()->new StudentAlreadyExistsException("No student with that id"));
		
		st.setId(student.getId());
		st.setName(student.getName());
		st.setAge(student.getAge());
		st.setSalary(student.getSalary());
		
		
		studentRepo.save(st);
		//return "Updated";*/
		
		studentRepo.save(student);
		
	}

	@Override
	public void deleteById(int id)  {
		// TODO Auto-generated method stub
		/*if(!studentRepo.existsById(id)) {
			throw new StudentDoesntExistException();
		} */
		studentRepo.deleteById(id);
	}

	@Override
	public Optional<Student> getStudentById(int id) {
		// TODO Auto-generated method stub
		/*if(!studentRepo.existsById(id)) {
			throw new StudentDoesntExistException();
		} */
		Optional<Student> studentObj=studentRepo.findById(id);
		return studentObj;
		
	}
	

}

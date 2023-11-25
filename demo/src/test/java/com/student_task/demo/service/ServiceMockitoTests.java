package com.student_task.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.stream.Stream;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

//import com.mongodb.connection.Stream;
import com.student_task.demo.entity.Student;
import com.student_task.demo.repo.StudentRepo;
import com.student_task.exception.StudentAlreadyExistsException;

@SpringBootTest
public class ServiceMockitoTests {
	@Autowired
	private StudentService studentService;
	@MockBean
	StudentRepo studentRepository;
	@InjectMocks
	private StudentServiceImpl studentServiceImpl;
	
	public List<Student> mystudents;

	 @Test
		void test_StudentServiceNotNull() {
			assertThat(studentServiceImpl).isNotNull();
		}
		
		@Test
		void test_StudentRepositoryNotNull() {
			assertThat(studentRepository).isNotNull();
		}
	
		@Test
		public void test_getStudents() {

			when(studentRepository.findAll())
			.thenReturn(Stream.of(new Student(1, "ritika", 20,23456)).collect(Collectors.toList()));
			assertEquals(1, studentService.getAllStudents().size());

		}
		
		@Test
		public void test_addStudent() throws StudentAlreadyExistsException {
			Student student = new Student(1, "ritika", 21,56567);
			studentService.addStudent(student);
			verify(studentRepository, times(1)).save(student);

		}
		
		@Test
		public void test_delete() {
			Student student = new Student(1, "ritika", 23,6789);
			studentRepository.delete(student);
			verify(studentRepository, times(1)).delete(student);
		}
		
		@Test
		public void test_update() {
			Student student = new Student(1, "ritika", 23,6789);
			studentService.update(1, student);
			verify(studentRepository, times(1)).save(student);
		}

		
}

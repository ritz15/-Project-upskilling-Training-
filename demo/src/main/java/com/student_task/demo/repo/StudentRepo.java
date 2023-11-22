package com.student_task.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.student_task.demo.entity.Student;

public interface StudentRepo  extends MongoRepository<Student,Integer>{

}

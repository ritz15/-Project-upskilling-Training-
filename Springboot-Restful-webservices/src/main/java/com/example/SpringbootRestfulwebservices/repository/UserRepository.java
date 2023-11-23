package com.example.SpringbootRestfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringbootRestfulwebservices.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

package com.example.todo.webservices.resfulwebservices.com.example.todo.webservices.resfulwebservices.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.webservices.resfulwebservices.com.example.todo.webservices.resfulwebservices.Todo;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long> {

	List<Todo> findByUserName(String userName);
}

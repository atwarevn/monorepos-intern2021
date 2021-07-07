package com.example.TodoAPI.repository;

import com.example.TodoAPI.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {


  List<Todo> findByContentContaining(String content);
}

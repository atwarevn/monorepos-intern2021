package com.example.TodoAPI.repository;

import com.example.TodoAPI.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}

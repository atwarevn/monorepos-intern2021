package com.example.TodoAPI.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TodoAPI.model.Todo;
import com.example.TodoAPI.repository.TodoRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TodoController {

  @Autowired
  private final TodoRepository todoRepository;

  public TodoController(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }
  @GetMapping("/todos")
  public ResponseEntity<List<Todo>> getAllTodos(@RequestParam(required = false) String title) {
    try {
      List<Todo> todos = new ArrayList<Todo>();

      if (title == null)
        todoRepository.findAll().forEach(todos::add);
      else
        todoRepository.findByContentContaining(title).forEach(todos::add);

      if (todos.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(todos, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/todo/{id}")
  public ResponseEntity<Todo> getTodoById(@PathVariable("id") Long id) {
    Optional<Todo> todoData = todoRepository.findById(id);

    if (todoData.isPresent()) {
      return new ResponseEntity<>(todoData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}

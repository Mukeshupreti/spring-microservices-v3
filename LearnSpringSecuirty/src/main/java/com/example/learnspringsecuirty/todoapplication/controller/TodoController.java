package com.example.learnspringsecuirty.todoapplication.controller;

import com.example.learnspringsecuirty.todoapplication.repository.TODORepository;
import com.example.learnspringsecuirty.todoapplication.repository.Todo;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController

public class TodoController {
  @Autowired
  private  TODORepository repository;


  private Logger logger = LoggerFactory.getLogger(getClass());

  @GetMapping("/todos")
  public List<Todo> retrieveAllTodos() {
    return null;
  }

  @GetMapping("csrftoken")
  public CsrfToken csrf(HttpServletRequest request) {
    return (CsrfToken) request.getAttribute("_csrf");
  }

  @GetMapping(path = "/basicauth")
  public String basicAuthCheck() {
    return "Success";
  }

  @GetMapping("/users/{userName}/todos/{id}")
  public Todo retrieveTodosForSpecificUser(@PathVariable("userName") String username,@PathVariable  Long id) {
    return repository.findById(id).orElse(null);
  }

  // This will fail if csrf filter is enabled (its enabled by default)
  // in DefaultSecurityFilterChain
  @PostMapping("/users/{username}/todos")
  public String createTodoForSpecificUser(@PathVariable String username, @RequestBody Todo todo) {
    logger.info("Create {} for {}", todo, username);
    repository.save(todo);
    return "added";
  }

  @GetMapping("/users/{userName}/todos")
  public List<Todo> retrieveTodosForSpecificUserAll(@PathVariable("userName") String username) {
    return repository.findAll();
  }

  @DeleteMapping("/users/{userName}/todos/{id}")
  public Todo deleteTodosForSpecificUserBy(@PathVariable("userName") String username,@PathVariable  Long id) {
    Todo todo=repository.findById(id).orElse(null);
    repository.delete(todo);
    return todo;
  }

  @PutMapping("/users/{username}/todos/{id}")
  public Todo updateTodo(@PathVariable String username,
      @PathVariable int id, @RequestBody Todo todo) {
    repository.save(todo);
    return todo;
  }

}


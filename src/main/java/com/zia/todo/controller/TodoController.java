package com.zia.todo.controller;

import com.zia.todo.domain.Todo;
import com.zia.todo.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    public TodoService service;

    Logger logger = LoggerFactory.getLogger(TodoController.class);
    @PostMapping
    public ResponseEntity<String> createTodo(@RequestBody Todo todo){
        service.createTodo(todo);
        logger.info("controller: todo created");
        return new ResponseEntity<String>("TODO created", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(){
       List<Todo> todos =  service.getTodos();
       return new ResponseEntity<>(todos,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable("id") int id){

        Todo todo = service.getTodoById(id);
//        return new ResponseEntity<>(todo, HttpStatus.OK);
        return ResponseEntity.ok(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todoToUpdate,@PathVariable("id") int id){
        Todo todo = service.updateTodo(id,todoToUpdate);
        return new ResponseEntity<>(todo, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") int id){
        service.deleteTodo(id);
        return ResponseEntity.ok("DELETED");
    }
}

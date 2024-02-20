package com.zia.todo.controller;

import com.zia.todo.domain.Todo;
import com.zia.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    public TodoService service;
    @PostMapping
    public String createTodo(@RequestBody Todo todo){
        service.createTodo(todo);
        return "TODO created";
    }

}

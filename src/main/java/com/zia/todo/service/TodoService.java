package com.zia.todo.service;

import com.zia.todo.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    List<Todo> todos = new ArrayList<Todo>();

    public Todo createTodo(Todo todo){
        todos.add(todo);
        return todo;
    }

}

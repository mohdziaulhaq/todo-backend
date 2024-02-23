package com.zia.todo.service;

import com.zia.todo.domain.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    Logger logger = LoggerFactory.getLogger(TodoService.class);

    List<Todo> todos = new ArrayList<Todo>();

    public Todo createTodo(Todo todo){
        todo.setCreatedDate(LocalDate.now());
        todos.add(todo);

        logger.info("todo added");
        return todo;
    }

    public List<Todo> getTodos(){
        return this.todos;
    }

    public Todo getTodoById(int id) {
        Todo todo = todos.stream().filter(t -> t.getId()==id).findFirst().get();
        logger.info("Todo : {}", todo);
        return todo;

    }

    public Todo updateTodo(int id, Todo todoToUpdate) {
        List<Todo> newTodosList = todos.stream().map(t -> {
            if (t.getId() == id) {
                t.setContent(todoToUpdate.getContent());
                t.setStatus(todoToUpdate.getStatus());
                t.setTitle(todoToUpdate.getTitle());
                return t;
            } else {
                return t;
            }
        }).collect(Collectors.toList());
        todos = newTodosList;

        return todoToUpdate;
    }

    public void deleteTodo(int id) {
        logger.info("DELETING TODO");
       List<Todo> newTodos = todos.stream().filter(t -> t.getId() != id).collect(Collectors.toList());
        todos = newTodos;
    }
}

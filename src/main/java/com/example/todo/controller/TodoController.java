package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/todo")
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping(path = "/save")
    public void saveTodo(@RequestBody Todo todo) {
        todoService.addNewTodo(todo);
    }

    @PutMapping(path = "/update/{id}")
    public void updateTodo(@PathVariable("id") String id,
                           @RequestBody Todo todo) {
        todoService.updateTodo(id,todo);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteTodo(@PathVariable("id") String id) {
        todoService.deleteTodo(id);
    }
}

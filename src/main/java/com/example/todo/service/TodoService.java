package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repo.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.example.todo.model.Status.TODO;

@AllArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public void addNewTodo(Todo todo) {
        todo.setId(UUID.randomUUID().toString());
        todo.setStatus(todo.getStatus() != null ?
                todo.getStatus() : TODO);
        todoRepository.insert(todo);
    }

    public void updateTodo(String id, Todo todo) {
        todoRepository.findById(id)
                .map(todoData -> {
                    todoData.setTitle(todo.getTitle() != null ?
                            todo.getTitle() : todoData.getTitle());
                    todoData.setStatus(todo.getStatus() != null ?
                            todo.getStatus() : todoData.getStatus());
                    todoRepository.save(todoData);
                    return null;
                });
    }

    public void deleteTodo(String id) {
        boolean exist = todoRepository.existsById(id);
        if (!exist) {
            throw new IllegalStateException(
                    "task with id " + id + " does not exists"
            );
        } else {
            todoRepository.deleteById(id);
        }
    }


}

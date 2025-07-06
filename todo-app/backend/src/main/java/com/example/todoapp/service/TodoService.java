package com.example.todoapp.service;

import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Flux<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Mono<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Mono<Todo> createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Mono<Todo> updateTodo(Long id, Todo todo) {
        return todoRepository.findById(id)
                .flatMap(existingTodo -> {
                    existingTodo.setTitle(todo.getTitle());
                    existingTodo.setDescription(todo.getDescription());
                    existingTodo.setCompleted(todo.getCompleted());
                    return todoRepository.save(existingTodo);
                });
    }

    public Mono<Void> deleteTodo(Long id) {
        return todoRepository.deleteById(id);
    }

    public Flux<Todo> getTodosByCompleted(Boolean completed) {
        return todoRepository.findByCompleted(completed);
    }
}
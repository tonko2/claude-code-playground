package com.example.todoapp.repository;

import com.example.todoapp.model.Todo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TodoRepository extends ReactiveCrudRepository<Todo, Long> {
    Flux<Todo> findByCompleted(Boolean completed);
}
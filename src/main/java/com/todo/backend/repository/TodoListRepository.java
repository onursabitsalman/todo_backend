package com.todo.backend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.backend.entity.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList, UUID> {
	
	List<TodoList> findByUserId(UUID userId);
	
	Optional<TodoList> findById(UUID id);

}

package com.todo.backend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.todo.backend.entity.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, UUID> {
	
	List<TodoItem> findByTodoListId(UUID todoListId);
	
	List<TodoItem> findByDependentItemId(UUID dependentItemId);
	
	Optional<TodoItem> findById(UUID id);
	
	@Modifying
	@Transactional
	@Query("DELETE from TodoItem t where t.id=:item_id")
	void deleteTodoItem(@Param("item_id") UUID id);

}

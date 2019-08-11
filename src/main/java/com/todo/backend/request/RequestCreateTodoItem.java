package com.todo.backend.request;

import java.time.OffsetDateTime;
import java.util.UUID;

public class RequestCreateTodoItem {

	private UUID todoListId;
	private String name;
	private String description;
	private OffsetDateTime deadline;
	private UUID dependedItemId;

	public UUID getTodoListId() {
		return todoListId;
	}

	public void setTodoListId(UUID todoListId) {
		this.todoListId = todoListId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OffsetDateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(OffsetDateTime deadline) {
		this.deadline = deadline;
	}

	public UUID getDependedItemId() {
		return dependedItemId;
	}

	public void setDependedItemId(UUID dependedItemId) {
		this.dependedItemId = dependedItemId;
	}

}

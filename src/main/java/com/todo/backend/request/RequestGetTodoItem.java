package com.todo.backend.request;

import java.util.UUID;

public class RequestGetTodoItem {

	private UUID todoListId;

	public UUID getTodoListId() {
		return todoListId;
	}

	public void setTodoListId(UUID todoListId) {
		this.todoListId = todoListId;
	}
	
	
}

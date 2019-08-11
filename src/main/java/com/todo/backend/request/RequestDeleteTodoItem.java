package com.todo.backend.request;

import java.util.UUID;

public class RequestDeleteTodoItem {
	
	private UUID id;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
}

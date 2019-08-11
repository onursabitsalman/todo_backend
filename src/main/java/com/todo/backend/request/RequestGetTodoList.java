package com.todo.backend.request;

import java.util.UUID;

public class RequestGetTodoList {
	
	private UUID userId;

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

}

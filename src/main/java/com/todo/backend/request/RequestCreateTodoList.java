package com.todo.backend.request;

import java.util.UUID;

public class RequestCreateTodoList {
	
	private UUID userId;
	private String name;
	
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

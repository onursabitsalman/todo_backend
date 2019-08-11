package com.todo.backend.response;

import java.util.List;

import com.todo.backend.entity.TodoItem;

public class ResponseGetTodoItem {
	
	private List<TodoItem> todoItemList;

	public List<TodoItem> getTodoItemList() {
		return todoItemList;
	}

	public void setTodoItemList(List<TodoItem> todoItemList) {
		this.todoItemList = todoItemList;
	}
	
}

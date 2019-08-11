package com.todo.backend.response;

import java.util.List;

import com.todo.backend.entity.TodoList;

public class ResponseGetTodoList {
	
	private List<TodoList> todoListList;

	public List<TodoList> getTodoListList() {
		return todoListList;
	}

	public void setTodoListList(List<TodoList> todoListList) {
		this.todoListList = todoListList;
	}
	
}

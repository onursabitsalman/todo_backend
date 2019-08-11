package com.todo.backend.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TodoList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3325096846064990809L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Type(type = "uuid-char")
	private UUID id;

	@Column(name = "userId")
	@Type(type = "uuid-char")
	private UUID userId;

	@Column(name = "name")
	private String name;

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "todoList", orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<TodoItem> todoItemList = new ArrayList<>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public List<TodoItem> getTodoItemList() {
		return todoItemList;
	}

	public void setTodoItemList(List<TodoItem> todoItemList) {
		this.todoItemList = todoItemList;
	}

}

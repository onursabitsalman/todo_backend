package com.todo.backend.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TodoItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4824170310205873669L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Type(type = "uuid-char")
	private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "deadline")
	private OffsetDateTime deadline;

	@Column(name = "status")
	private String status;

	@Column(name = "dependentItemId")
	@Type(type = "uuid-char")
	private UUID dependentItemId;
	
	@ManyToOne
	@JoinColumn(name = "todo_list_id")
	@JsonIgnore
	private TodoList todoList;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UUID getDependentItemId() {
		return dependentItemId;
	}

	public void setDependentItemId(UUID dependentItemId) {
		this.dependentItemId = dependentItemId;
	}

	public TodoList getTodoList() {
		return todoList;
	}

	public void setTodoList(TodoList todoList) {
		this.todoList = todoList;
	}

}

package com.todo.backend.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.backend.constant.TodoConstants;
import com.todo.backend.entity.TodoItem;
import com.todo.backend.entity.TodoList;
import com.todo.backend.exception.CustomException;
import com.todo.backend.intf.ITodoService;
import com.todo.backend.repository.TodoItemRepository;
import com.todo.backend.repository.TodoListRepository;
import com.todo.backend.request.RequestCompleteTodoItem;
import com.todo.backend.request.RequestCreateTodoItem;
import com.todo.backend.request.RequestCreateTodoList;
import com.todo.backend.request.RequestDeleteTodoItem;
import com.todo.backend.request.RequestDeleteTodoList;
import com.todo.backend.request.RequestGetTodoItem;
import com.todo.backend.request.RequestGetTodoList;
import com.todo.backend.response.ResponseCompleteTodoItem;
import com.todo.backend.response.ResponseCreateTodoItem;
import com.todo.backend.response.ResponseCreateTodoList;
import com.todo.backend.response.ResponseDeleteTodoItem;
import com.todo.backend.response.ResponseDeleteTodoList;
import com.todo.backend.response.ResponseGetTodoItem;
import com.todo.backend.response.ResponseGetTodoList;

@Transactional(rollbackFor = Exception.class)
@Service
public class TodoService implements ITodoService {

	@Autowired
	private TodoItemRepository todoItemRepository;

	@Autowired
	private TodoListRepository todoListRepository;

	@Override
	public ResponseGetTodoList getTodoList(RequestGetTodoList request) throws ServiceException {

		ResponseGetTodoList response = new ResponseGetTodoList();
		List<TodoList> todoListList = todoListRepository.findByUserId(request.getUserId());
		response.setTodoListList(todoListList);
		return response;

	}

	@Override
	public ResponseCreateTodoList createTodoList(RequestCreateTodoList request) throws ServiceException {

		ResponseCreateTodoList response = new ResponseCreateTodoList();
		TodoList todoList = new TodoList();
		todoList.setUserId(request.getUserId());
		todoList.setName(request.getName());
		todoListRepository.save(todoList);
		response.setMessage(TodoConstants.SUCCESSFUL_CREATE_TODO_LIST);
		return response;

	}

	@Override
	public ResponseDeleteTodoList deleteTodoList(RequestDeleteTodoList request) throws ServiceException {

		ResponseDeleteTodoList response = new ResponseDeleteTodoList();
		TodoList todoList = todoListRepository.findById(request.getId()).get();
		todoListRepository.delete(todoList);
		response.setMessage(TodoConstants.SUCCESSFUL_DELETE_TODO_LIST);
		return response;

	}

	@Override
	public ResponseGetTodoItem getTodoItem(RequestGetTodoItem request) throws ServiceException {

		ResponseGetTodoItem response = new ResponseGetTodoItem();
		TodoList todoList = todoListRepository.findById(request.getTodoListId()).get();
		List<TodoItem> todoItemList = todoList.getTodoItemList();
		response.setTodoItemList(todoItemList);
		return response;

	}

	@Override
	public ResponseCreateTodoItem createTodoItem(RequestCreateTodoItem request) throws ServiceException {

		ResponseCreateTodoItem response = new ResponseCreateTodoItem();
		TodoItem todoItem = new TodoItem();
		TodoList todoList = todoListRepository.findById(request.getTodoListId()).get();
		todoItem.setTodoList(todoList);
		todoItem.setName(request.getName());
		todoItem.setDescription(request.getDescription());
		todoItem.setDeadline(request.getDeadline());
		todoItem.setStatus(TodoConstants.INCOMPLETE_STATUS_ITEM);
		todoItem.setDependentItemId(request.getDependedItemId());
		todoItemRepository.save(todoItem);
		response.setMessage(TodoConstants.SUCCESSFUL_CREATE_TODO_ITEM);
		return response;

	}

	@Override
	public ResponseDeleteTodoItem deleteTodoItem(RequestDeleteTodoItem request) throws ServiceException {

		ResponseDeleteTodoItem response = new ResponseDeleteTodoItem();
		List<TodoItem> todoItemList = todoItemRepository.findByDependentItemId(request.getId());
		for (int i = 0; i < todoItemList.size(); i++) {
			TodoItem todoItem = todoItemList.get(i);
			todoItem.setDependentItemId(null);
			todoItemRepository.save(todoItem);
		}
		todoItemRepository.deleteTodoItem(request.getId());
		response.setMessage(TodoConstants.SUCCESSFUL_DELETE_TODO_ITEM);
		return response;

	}

	@Override
	public ResponseCompleteTodoItem completeTodoItem(RequestCompleteTodoItem request) throws ServiceException {

		if (request.getStatus().equals(TodoConstants.INCOMPLETE_STATUS_ITEM)) {
			TodoItem todoItem = todoItemRepository.findById(request.getId()).get();
			TodoItem dependentTodoItem = null;
			if (todoItem.getDependentItemId() != null) {
				dependentTodoItem = todoItemRepository.findById(todoItem.getDependentItemId()).get();
			}
			if (dependentTodoItem != null && dependentTodoItem.getStatus().equals(TodoConstants.INCOMPLETE_STATUS_ITEM)) {
				throw new CustomException(TodoConstants.FAILED_UPDATE_ITEM_STATUS, HttpStatus.UNPROCESSABLE_ENTITY);
			} else {
				ResponseCompleteTodoItem response = new ResponseCompleteTodoItem();
				todoItem.setStatus(TodoConstants.COMPLETE_STATUS_ITEM);
				todoItemRepository.save(todoItem);
				response.setMessage(TodoConstants.SUCCESSFUL_UPDATE_ITEM_STATUS);
				return response;
			}
		} else {
			throw new CustomException(TodoConstants.FAILED_UPDATE_ITEM_STATUS, HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

}

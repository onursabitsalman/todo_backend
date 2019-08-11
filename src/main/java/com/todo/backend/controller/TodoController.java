package com.todo.backend.controller;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.backend.intf.ITodoService;
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

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/todo")
@Api(tags = "todo")
public class TodoController {

	@Autowired
	ITodoService todoService;

	@PostMapping(path = "/getTodoList")
	public ResponseGetTodoList getTodoList(@RequestBody RequestGetTodoList request) throws ServiceException {
		return todoService.getTodoList(request);

	}

	@PostMapping(path = "/createTodoList")
	public ResponseCreateTodoList createTodoList(@RequestBody RequestCreateTodoList request) throws ServiceException {
		return todoService.createTodoList(request);

	}
	
	@PostMapping(path = "/deleteTodoList")
	public ResponseDeleteTodoList deleteTodoList(@RequestBody RequestDeleteTodoList request) throws ServiceException {
		return todoService.deleteTodoList(request);

	}

	@PostMapping(path = "/getTodoItem")
	public ResponseGetTodoItem getTodoItem(@RequestBody RequestGetTodoItem request) throws ServiceException {
		return todoService.getTodoItem(request);

	}

	@PostMapping(path = "/createTodoItem")
	public ResponseCreateTodoItem createTodoItem(@RequestBody RequestCreateTodoItem request) throws ServiceException {
		return todoService.createTodoItem(request);

	}
	
	@PostMapping(path = "/deleteTodoItem")
	public ResponseDeleteTodoItem deleteTodoItem(@RequestBody RequestDeleteTodoItem request) throws ServiceException {
		return todoService.deleteTodoItem(request);

	}
	
	@PostMapping(path = "/completeTodoItem")
	public ResponseCompleteTodoItem completeTodoItem(@RequestBody RequestCompleteTodoItem request) throws ServiceException {
		return todoService.completeTodoItem(request);

	}

}

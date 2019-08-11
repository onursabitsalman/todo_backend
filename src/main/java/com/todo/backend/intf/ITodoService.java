package com.todo.backend.intf;

import javax.jws.WebService;

import org.hibernate.service.spi.ServiceException;

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

@WebService
public interface ITodoService {

	ResponseGetTodoList getTodoList(RequestGetTodoList request) throws ServiceException;

	ResponseCreateTodoList createTodoList(RequestCreateTodoList request) throws ServiceException;

	ResponseGetTodoItem getTodoItem(RequestGetTodoItem request) throws ServiceException;

	ResponseCreateTodoItem createTodoItem(RequestCreateTodoItem request) throws ServiceException;

	ResponseDeleteTodoList deleteTodoList(RequestDeleteTodoList request) throws ServiceException;

	ResponseDeleteTodoItem deleteTodoItem(RequestDeleteTodoItem request) throws ServiceException;

	ResponseCompleteTodoItem completeTodoItem(RequestCompleteTodoItem request) throws ServiceException;

}

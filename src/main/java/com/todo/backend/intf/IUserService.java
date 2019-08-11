package com.todo.backend.intf;

import javax.jws.WebService;

import org.hibernate.service.spi.ServiceException;

import com.todo.backend.request.RequestLogin;
import com.todo.backend.request.RequestRegister;
import com.todo.backend.response.ResponseLogin;
import com.todo.backend.response.ResponseRegister;

@WebService
public interface IUserService {

	ResponseLogin login(RequestLogin request) throws ServiceException;

	ResponseRegister register(RequestRegister request) throws ServiceException;

}

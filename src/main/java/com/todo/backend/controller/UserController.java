package com.todo.backend.controller;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.backend.intf.IUserService;
import com.todo.backend.request.RequestLogin;
import com.todo.backend.request.RequestRegister;
import com.todo.backend.response.ResponseLogin;
import com.todo.backend.response.ResponseRegister;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/user")
@Api(tags = "user")
public class UserController {
	
	@Autowired
    IUserService userService;

    @PostMapping(path = "/login")
    public ResponseLogin login(@RequestBody RequestLogin request) throws ServiceException {
    	ResponseLogin response = userService.login(request);
    	return response;
      
    }
    
    @PostMapping(path = "/register")
    public ResponseRegister register(@RequestBody RequestRegister request) throws ServiceException {
    	ResponseRegister response = userService.register(request);
    	return response;
      
    }

}

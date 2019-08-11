package com.todo.backend.service;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.backend.constant.UserConstants;
import com.todo.backend.entity.User;
import com.todo.backend.exception.CustomException;
import com.todo.backend.intf.IUserService;
import com.todo.backend.repository.UserRepository;
import com.todo.backend.request.RequestLogin;
import com.todo.backend.request.RequestRegister;
import com.todo.backend.response.ResponseLogin;
import com.todo.backend.response.ResponseRegister;

@Transactional(rollbackFor = Exception.class)
@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseLogin login(RequestLogin request) throws ServiceException {

		try {
			ResponseLogin response = new ResponseLogin();
			User user = userRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword()).get();
			response.setUser(user);
			return response;
		} catch (Exception e) {
			throw new CustomException(UserConstants.FAILED_LOGIN, HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

	@Override
	public ResponseRegister register(RequestRegister request) throws ServiceException {

		ResponseRegister response = new ResponseRegister();

		if (!userRepository.existsByUsername(request.getUsername())) {
			User user = new User();
			user.setUsername(request.getUsername());
			user.setPassword(request.getPassword());
			userRepository.save(user);
			response.setRegisterStatus(true);
			return response;

		} else {
			throw new CustomException(UserConstants.FAILED_REGISTER, HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

}

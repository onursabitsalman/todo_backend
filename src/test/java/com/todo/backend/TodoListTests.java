//package com.todo.backend;
//
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.todo.backend.controller.UserController;
//import com.todo.backend.service.UserService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//public class TodoListTests {
//
//	private MockMvc mockMvc;
//
//	@Mock
//	private UserService userService;
//
//	@InjectMocks
//	private UserController userController;
//
//	@Before
//	public void setUp() throws Exception {
//		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//	}
//
//}

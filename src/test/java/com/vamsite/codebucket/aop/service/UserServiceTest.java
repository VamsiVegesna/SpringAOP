package com.vamsite.codebucket.aop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vamsite.codebucket.aop.model.Role;
import com.vamsite.codebucket.aop.model.User;
import com.vamsite.codebucket.aop.service.UserService;
import com.vamsite.codebucket.aop.ui.AdminComponent;
import com.vamsite.codebucket.aop.ui.ApproverComponent;
import com.vamsite.codebucket.aop.ui.DeveloperComponent;
import com.vamsite.codebucket.aop.ui.GuestComponent;
import com.vamsite.codebucket.aop.ui.UIFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private UIFactory uiFactory;
	
	@Test
	public void testGetUserDetails() throws Exception {
		userService.setCurrentUser(new User(Role.APPROVER));
		uiFactory.createComponent(AdminComponent.class);
		uiFactory.createComponent(GuestComponent.class);
		uiFactory.createComponent(DeveloperComponent.class);
		uiFactory.createComponent(ApproverComponent.class);
	}
}


package com.vamsite.codebucket.aop.service;

import org.springframework.stereotype.Service;

import com.vamsite.codebucket.aop.model.Role;
import com.vamsite.codebucket.aop.model.User;

@Service
public class UserService {

	private User user;

	public User getCurrentUser() {
		return user;
	}

	public void setCurrentUser(User user) {
		this.user = user;
	}

	public Role getUserRole() {
		if (user == null) {
			return null;
		}
		return user.getUserRole();
	}

}

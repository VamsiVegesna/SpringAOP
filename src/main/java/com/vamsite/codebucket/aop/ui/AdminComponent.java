package com.vamsite.codebucket.aop.ui;

import com.vamsite.codebucket.aop.AccessControl;
import com.vamsite.codebucket.aop.model.Role;

@AccessControl(allowedRoles = {Role.ADMIN})
public class AdminComponent extends UIComponent{

	public AdminComponent() {
		System.out.println(getComponent());
	}
	
	@Override
	public String getComponent() {
		
		return "Admin Component created";
	}

}



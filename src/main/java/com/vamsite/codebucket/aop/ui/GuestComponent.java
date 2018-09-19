package com.vamsite.codebucket.aop.ui;

import com.vamsite.codebucket.aop.AccessControl;
import com.vamsite.codebucket.aop.model.Role;

@AccessControl(allowedRoles = {Role.GUEST, Role.DEVELOPER, Role.APPROVER, Role.ADMIN})
public class GuestComponent extends UIComponent{

	public GuestComponent() {
		System.out.println(getComponent());
	}
	
	@Override
	public String getComponent() {
		
		return "Guest Component created";
	}

}



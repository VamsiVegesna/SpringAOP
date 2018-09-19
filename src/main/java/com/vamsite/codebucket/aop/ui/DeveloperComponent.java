package com.vamsite.codebucket.aop.ui;

import com.vamsite.codebucket.aop.AccessControl;
import com.vamsite.codebucket.aop.model.Role;

@AccessControl(allowedRoles = {Role.DEVELOPER, Role.APPROVER})
public class DeveloperComponent extends UIComponent{

	public DeveloperComponent() {
		System.out.println(getComponent());
	}
	
	@Override
	public String getComponent() {
		
		return "Developer Component created";
	}
	
}



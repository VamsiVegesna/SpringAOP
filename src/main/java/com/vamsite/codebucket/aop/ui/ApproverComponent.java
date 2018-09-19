package com.vamsite.codebucket.aop.ui;

import com.vamsite.codebucket.aop.AccessControl;
import com.vamsite.codebucket.aop.model.Role;

@AccessControl(allowedRoles = {Role.APPROVER})
public class ApproverComponent extends UIComponent{

	public ApproverComponent() {
		System.out.println(getComponent());
	}
	
	@Override
	public String getComponent() {
		
		return "Approver Component created";
	}

}



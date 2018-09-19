package com.vamsite.codebucket.aop.model;

public enum Role {

	ADMIN("ADMN"), APPROVER("APRVR"), DEVELOPER("DVLPR"), GUEST("GST");

	private String name;

	private Role(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

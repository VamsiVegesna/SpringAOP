package com.vamsite.codebucket.aop.model;

public class User {

	private Role userRole;
	 
	 public User(Role userRole) {
	  this.userRole = userRole;
	 }
	 
	 public Role getUserRole() {
	  return userRole;
	 }
	 
	 public void setUserRole(Role userRole) {
	  this.userRole = userRole;
	 }
}

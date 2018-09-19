package com.vamsite.codebucket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.vamsite.codebucket.aop.AccessControl;
import com.vamsite.codebucket.aop.model.Role;

@AccessControl(allowedRoles = { Role.ADMIN })
@SpringBootApplication
@ComponentScan("com.vamsite.codebucket.aop")
public class CodebucketApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodebucketApplication.class, args);
	}
}

package com.vamsite.codebucket.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.vamsite.codebucket.aop.model.Role;
import com.vamsite.codebucket.aop.service.UserService;
import com.vamsite.codebucket.aop.ui.UIComponent;

@Aspect
@Configuration
public class SecurityAspect {

	@Autowired
	private UserService userService;

	@Pointcut("execution(* com.vamsite.codebucket.aop.ui.UIFactory.*(..))")
	public void getPointCuts() {}
	
	@Around("getPointCuts()")
	public UIComponent checkAccess(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		Object[] arguments = thisJoinPoint.getArgs();
		if (arguments.length == 0) {
			return null;
		}

		Annotation annotation = checkAnnotation(arguments);
		boolean securityAnnotationPresent = (annotation != null);

		if (securityAnnotationPresent) {
			boolean userHasRole = verifyRole(annotation);
			if (!userHasRole) {
				System.out.println("Current user doesn't have permissions to create this component");
				return null;
			}
		}
		System.out.println("Current user has required permissions for creating this component");
		return (UIComponent) thisJoinPoint.proceed();
	}

	/**
	 *To check if the given component class is annotated with AccessControl 
	 * annotation
	 * @param arguments
	 * @return annotation(if exists)
	 */
	private Annotation checkAnnotation(Object[] arguments) {
		Object concreteClass = arguments[0];
		System.out.println("Loading "+concreteClass);
		System.out.println("Checking access..");
		AnnotatedElement annotatedElement = (AnnotatedElement) concreteClass;
		Annotation annotation = annotatedElement.getAnnotation(AccessControl.class);
		return annotation;
	}

	/**
	 * This method verifies whether the annotation has required roles 
	 * to create desired component
	 * @param annotation
	 * @return user role(if exists)
	 */
	private boolean verifyRole(Annotation annotation) {
		AccessControl annotationRule = (AccessControl) annotation;
		List<Role> requiredRolesList = Arrays.asList(annotationRule.allowedRoles());
		System.out.println("Allowed Roles: "+requiredRolesList);
		Role userRole = userService.getUserRole();
		return requiredRolesList.contains(userRole);
	}
}

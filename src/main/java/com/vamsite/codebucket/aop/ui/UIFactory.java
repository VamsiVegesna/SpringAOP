package com.vamsite.codebucket.aop.ui;

import org.springframework.stereotype.Component;

@Component
public class UIFactory {

	public UIComponent createComponent(Class<? extends UIComponent> componentClass) 
			throws Exception {
		
		if(componentClass == null) {
			throw new Exception("Provide class name");
		}
		
		return (UIComponent) Class.forName(componentClass.getName()).newInstance();
	}
}



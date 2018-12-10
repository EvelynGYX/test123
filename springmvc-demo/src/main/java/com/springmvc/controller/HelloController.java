package com.springmvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller  
public class HelloController{
	private static final Log logger = LogFactory.getLog(HelloController.class);
	
	@RequestMapping(value="/hello")
	public String handleRequest(){
		logger.info("handleRequest");
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "Hello Word!GYX");
		return "welcome";
	}
}
package com.springmvc.controller;
import com.springmvc.domain.User;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/user")
public class UserController {
	private static ArrayList<User> userList;
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	public UserController() {
		super();
		userList = new ArrayList<User>();
	}
	
	@RequestMapping(value="/login")
	public String login(
			@RequestParam("email") String email,
			@RequestParam("username") String username,
			@RequestParam("password") String pwd,
			Model model) {
		logger.info("email:" + email + "pwd:" + pwd + "username:" + username);
		for(User user : userList) {
			if(user.getEmail().equals(email)
					&& user.getUsername().equals(username)
					&& user.getPassword().equals(pwd)) {
				model.addAttribute("user", user);
				return "welcome";
			}			
		}
		return "loginForm";
	}
	
	@RequestMapping(value="/registerForm", method=RequestMethod.GET)
	public String register() {
		logger.info("register GET");
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerForm() {
		logger.info("register GET");
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(
			@RequestParam("email") String email,
			@RequestParam("username") String username,
			@RequestParam("password") String pwd) {
		logger.info("register POST");
		User user = new User();
		user.setUser(email, username, pwd);
		userList.add(user);
		return "loginForm";
	}
	
}

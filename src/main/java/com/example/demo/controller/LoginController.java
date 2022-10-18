package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String welcomePage(ModelMap model, @RequestParam String userId, @RequestParam String password) {
//		if (userId.equals("admin") && password.equals("root")) {
//			model.put("userId",userId);
//			return "welcome";
//		}
//		model.put("errorMsg", "please provide the correct userid and password");
		
		
		User user = userService.getUserByUserId(userId);
		
		if (user.getPassword().equals(password)) {
			model.put("userId", userId);
			return "welcome";
		}
		
		
		return "login";
	}
}

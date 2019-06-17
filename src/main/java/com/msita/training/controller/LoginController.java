package com.msita.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.msita.training.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String goToFormLogin() {
		return "login";
	}
	//springmvc/login/authenticate
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password,
						HttpServletRequest request) {
		String page = "";
		boolean rs=loginService.login(username, password);
		if(rs==true) {
			request.getSession().setAttribute("username",username);
			page="home";
		}else {
			page="error";
		}
		return "redirect:/"+page;
	}
}

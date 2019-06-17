package com.msita.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msita.training.service.LoginService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		return "register";
	}

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
		public String register(@RequestParam("username") String username, @RequestParam("password") String password,
								@RequestParam("fullname") String fullname,@RequestParam("email") String email,
							@RequestParam("phonenumber") String phonenumber) {
		loginService.insert(username, password, fullname, email, phonenumber);
		return "added successful.";
	}
}

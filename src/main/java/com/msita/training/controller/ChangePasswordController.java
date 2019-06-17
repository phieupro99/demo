package com.msita.training.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.msita.training.service.LoginService;

@Controller
@RequestMapping("/changepassword")
public class ChangePasswordController {


	@Autowired
	private LoginService loginService;

	@RequestMapping(method = RequestMethod.GET)
	public String goToFormChangePassword() {
		return "changepassword";
	}
	@RequestMapping(value = "/update" ,  method = RequestMethod.POST)
		public String register(@RequestParam("usernamesss") String username, @RequestParam("oldpassword") String oldpassword,
							   @RequestParam("newpassword") String newpassword,@RequestParam("confnewpassword") String confnewpassword)
		{	String page = "";
		boolean rs = loginService.change(username, oldpassword,newpassword,confnewpassword);
		if (rs == true) {
			
			page = "changesuccess";
		} else {
			page = "error";
		}
		return page;
		}
}

package com.msita.training.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.msita.training.dao.LoginDAO;
import com.msita.training.vo.User;

@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDAO;

	public boolean login(String username, String pass) {
		boolean rs = false;	

		User user = loginDAO.login(username);

		if (user != null) {
			if (user.getPassword().equals(pass)) {
				rs = true;
			}
		}
		return rs;
	}
	public void insert(String username,String password,String fullname,String email,String phonenumber ) {
		loginDAO.insert(username, password, fullname, email, phonenumber);
	}
	public boolean change(String username,String oldpassword,String newpassword,String confnewpassword ) {
		boolean rs = false;
		User user = loginDAO.login(username);
		if (oldpassword.equals(user.getPassword())&&confnewpassword.equals(newpassword))
		{
			loginDAO.change(username, newpassword);
			rs=true;
		}
			
		else rs=false;
		return rs;
	}

}
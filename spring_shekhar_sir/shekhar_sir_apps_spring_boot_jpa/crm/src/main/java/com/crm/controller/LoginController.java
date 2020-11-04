package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.crm.dao.ILoginDao;
import com.crm.model.LoginBean;

@Controller
public class LoginController {
	
	@Autowired
	ILoginDao  dao;
	
	@GetMapping("/login")
	public  String getLoginPage(Model  model) {
		model.addAttribute("loginBean", new  LoginBean());
		return "login";
	}
	
	@PostMapping("/userLogin")
	public  String  userLogin(@ModelAttribute  LoginBean loginBean, Model model) {
		boolean flag=dao.loginCheck(loginBean.getEmail(), loginBean.getPassword());
		if(flag==false) {
			model.addAttribute("msg", "Bad Credentials");
			return  "login";
		}
		else {
			return  "loginSuccess";
		}
	}

}

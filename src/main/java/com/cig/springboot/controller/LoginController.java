package com.cig.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

	@PostMapping("/tologin")
	public String toLogin(@RequestParam String userName, @RequestParam String passWord, Model model, HttpSession session){
		if(!StringUtils.isEmpty(userName) && "123456".equals(passWord)){
			session.setAttribute("loginUser",userName);
			return "redirect:/main.html";
		}else {
			model.addAttribute("msg","用户名密码错误！");
			return "login";
		}

	}
}

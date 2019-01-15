package com.cig.springboot.controller;

import com.cig.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {
//	@RequestMapping("/hello")
//	public String helloWorld(Map<String,Object> map){
//		map.put("hello","你好");
//		return "hello";
//	}
	@ResponseBody
	@RequestMapping("/hello")
	public String hello(@RequestParam("user") String user){
		if(user.equals("aaa")){
			throw new UserNotExistException();
		}
		return "Hello World";
	}
}

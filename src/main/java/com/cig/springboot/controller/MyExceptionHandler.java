package com.cig.springboot.controller;

import com.cig.springboot.exception.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//自定义异常处理&返回定制json数据
@ControllerAdvice
public class MyExceptionHandler {

//	@ResponseBody
//	@ExceptionHandler(UserNotExistException.class)
//	public Map<String,Object> handleException(Exception e){
//		Map<String,Object> map=new HashMap<>();
//		map.put("code","user.notexist");
//		map.put("message",e.getMessage());
//		return map;
//	}

	@ExceptionHandler(UserNotExistException.class)
	public String handleException(Exception e, HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		//传入我们自己的错误状态码 4xx  5xx
		// spring boot 自己设置的状态码 Integer statusCode=(Integer)request.getAttribute("javax.servlet.error.status_code");
		map.put("code","user.notexist");
		map.put("message","用户出错啦");
		request.setAttribute("javax.servlet.error.status_code",400);
		request.setAttribute("ext",map);
		//转发到/error
		return "forward:/error";
	}
}

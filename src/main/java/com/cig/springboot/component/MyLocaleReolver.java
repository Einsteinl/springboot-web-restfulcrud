package com.cig.springboot.component;

import com.sun.corba.se.spi.orbutil.closure.Closure;

import org.omg.CORBA.Object;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Set;

/**
 * 可以 在链接上携带区域信息
 */
public class MyLocaleReolver implements LocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String l=request.getParameter("l");
		Locale locale=Locale.getDefault();
		if(!StringUtils.isEmpty(l)){
			String[] split=l.split("_");
			locale =new Locale(split[0],split[1]);
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

	}
	@Bean
	public LocaleResolver localeResolver(){
		return new MyLocaleReolver();
	}
}

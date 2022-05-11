package com.mvc.controller;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class Hello2 {
	@RequestMapping(value = "/greet2")
	@ResponseBody()
	public String greet() {
		return "Hello to Spring MVC....";
	}
	@RequestMapping(value = "/welcome2")
	@ResponseBody()
	public String welcome() {
		return "Welcome to my Spring MVC2";
	}
}

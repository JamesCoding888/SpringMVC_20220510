package com.mvc.controller;
import org.springframework.stereotype.Controller;   
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class Hello {
	@RequestMapping(value = "/greet")
	@ResponseBody()
	public String greet() {
		return "Hello to Spring MVC";
	}
	
	@RequestMapping(value = "/welcome")
	@ResponseBody()
	public String welcome() {
		return "Welcome to my Spring MVC";
	}
	
	/*
	 * 路徑: /sayhi?name=james&age=18
	 */
	@RequestMapping(value = "/sayhi")
	@ResponseBody 
	public String sayHi(@RequestParam(value = "name", defaultValue = "unKnown" ,required = false) String name,
						@RequestParam("age") Integer age) {
		return "Hello " + name + ", " + age;
	}
}

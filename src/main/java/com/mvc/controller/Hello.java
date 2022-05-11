package com.mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class Hello {
	@RequestMapping(value = "/greet")
	@ResponseBody()
	public String greet() {
		return "Hello to Spring MVC";
	}
}

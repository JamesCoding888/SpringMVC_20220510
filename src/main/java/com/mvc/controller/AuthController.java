package com.mvc.controller;
import java.util.Date; 
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mvc.exception.AuthException;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		int n = new Random().nextInt(3); // 亂數抓取 0, 1, 2 
		switch(n) { // n=1 則拋出 AuthException; n=2 則拋出 NullPointerException 
			case 1:
				throw new AuthException(new Date(), "Auth error page");
			case 2:
				throw new NullPointerException("Other error...");
		}		
		return "Welcome"; // n=0 因為配置 @ResponseBody 
	}

}

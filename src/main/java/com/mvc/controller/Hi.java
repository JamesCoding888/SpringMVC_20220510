package com.mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/hi")
public class Hi {

	@GetMapping(value = "/sayhi")
	public ModelAndView sayhi() {
		ModelAndView mav = new ModelAndView();
		// 第一種作法: 直接定義 sayhi.jsp 路徑
		// mav.setViewName("/WEB-INF/view/sayhi.jsp"); 
		// 第二種作法: 於 springmvc-servlet.xml 中有定義 ViewResolver 標籤的寫法
		mav.setViewName("sayhi");
		mav.addObject("username", "John");
		return mav;
	}
	@GetMapping(value = "/sayhi2")
	//@ResponseBody // 請勿加上此 annotation，這樣做會得到 sayhi 字串 而不是 sayhi.jsp 的內容
	public  String sayhi2(Model model) {
		model.addAttribute("username", "Mary");
		return "sayhi"; // 直接回傳的就是 view 的名字 (字串)
	}

	
}

//mav.setViewName("/WEB-INF/view/sayhi.jsp");
//mav.setViewName("/sayhi.jsp"); // 於 springmvc-servlet.xml 中有定義 ViewResolver 標籤的寫法

//@GetMapping(value = "/sayhi2")
//public String sayhi2(Model model) {
//	model.addAttribute("username", "Mary");
//	return "sayhi"; // 直接回傳的就是 view 的名字(字串)
//}
package com.mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mvc.entity.ExamTest;

@Controller
@RequestMapping("/exam")
public class ExamController {
	@RequestMapping(value = {"/", "/index"})
	public String index(Model model) {
		ExamTest e = new ExamTest();
		e.setId("101");
		e.setName("809");
		e.setSlot(new String[] {"A", "C"} );
		e.setPay("true");
		e.setNote("Thanks...");
		model.addAttribute("examTest", e);
		return "exam";
		
		
	}

}

package com.mvc.controller;
import java.util.List; 
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mvc.entity.ExamTest;
@Controller
@RequestMapping("/exam")
public class ExamController  {	

	// CopyOnWriteArrayList is MultipleThread-safe
	private static List<ExamTest> exams = new CopyOnWriteArrayList<>();
	
	@RequestMapping(value = {"/", "/index"})
	public String index(Model model) {
		ExamTest e = new ExamTest();
		/* Entity Bean 初始化 for 驗證前端 exam.jsp 的資料可被呈現在表單中
		e.setId("101");
		e.setName("809");
		e.setSlot(new String[] {"A", "C"} );
		e.setPay("true");
		e.setNote("Thanks...");
		*/
		model.addAttribute("examTest", e); // 給表單使用
		model.addAttribute("exams", exams); // 給資料呈現使用
		return "exam";  // return 的名稱必須跟前端的檔名一致，e,g, exam.jsp 
	}
	
	// CRUD create, read, update, delete
	@RequestMapping(value = "/create")
	public String create (ExamTest examTest) {		
		exams.add(examTest); // 新增
		System.out.println(examTest);
		return "redirect:/mvc/exam/"; // 新增完畢後，重導致首頁	
	}
}

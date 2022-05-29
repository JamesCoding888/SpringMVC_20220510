package com.mvc.controller;
import java.util.ArrayList; 
import java.util.List; 
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mvc.entity.ExamName;
import com.mvc.entity.ExamTest;
import com.mvc.validator.ExamValidator;
@Controller
@RequestMapping("/exam")
public class ExamController  {	

	// CopyOnWriteArrayList is MultipleThread-safe
	private static List<ExamTest> exams = new CopyOnWriteArrayList<>();
	
	private static List<ExamName> examNames = new ArrayList<>();
	static {
		examNames.add(new ExamName("808","1Z0-808"));
		examNames.add(new ExamName("809","1Z0-809"));
		examNames.add(new ExamName("900","1Z0-900"));
		examNames.add(new ExamName("819","1Z0-819"));
	}
	
	@Autowired
	private ExamValidator examValidator;
	
	@RequestMapping(value = {"/", "/index"})
	public String index(Model model) {
		ExamTest e = new ExamTest();
		System.out.println(e);
		/* Entity Bean 初始化 for 驗證前端 exam.jsp 的資料可被呈現在表單中
		e.setId("101");
		e.setName("809");
		e.setSlot(new String[] {"A", "C"} );
		e.setPay("true");
		e.setNote("Thanks...");
		*/
		model.addAttribute("examTest", e); // 給表單使用	
		model.addAttribute("exams", exams); // 給資料呈現使用
		model.addAttribute("examNames", examNames); // 給資料呈現使用
		model.addAttribute("action", "create");
		// 統計資料				
		model.addAttribute("stat1", getStat1());
		model.addAttribute("stat2", getStat2());
		return "exam";  // return 的名稱必須跟前端的檔名一致，e,g, exam.jsp 
	}
	
	// CRUD create, read, update, delete
	@RequestMapping(value = "/create")
	public String create (ExamTest examTest, Model model, BindingResult result) {		
		System.out.println(examTest);
		// 驗證 examTest 物件
		examValidator.validate(examTest, result);
		// 驗證結果是否有錯誤 ?
		if(result.hasErrors()) {
			model.addAttribute("exams", exams); // 給資料呈現使用
			model.addAttribute("examNames", examNames); // 給資料呈現使用
			model.addAttribute("action", "create");
			// 統計資料				
			model.addAttribute("stat1", getStat1());
			model.addAttribute("stat2", getStat2());
			return "exam";
		}
		exams.add(examTest); // 新增		
		return "redirect:/mvc/exam/"; // 新增完畢後，重導致首頁	
	}
	
	@RequestMapping(value = "/get/{id}")
	public String get(@PathVariable("id") String id, Model model) {
		Optional<ExamTest> optExam = exams.stream().filter(e -> e.getId().equals(id)).findFirst(); 
		// 透過 Optional 來判斷，是否被查找的資料 (id) 是否存在，如果表單中有 id， 則得到 id 值，如果沒有則得到一個物件 
		model.addAttribute("examTest", optExam.isPresent() ? optExam.get() : new ExamTest()); // 給表單使用
		model.addAttribute("exams", exams); // 給資料呈現使用
		model.addAttribute("examNames", examNames); // 給資料呈現使用
		model.addAttribute("action", "update");
		// 統計資料
		model.addAttribute("stat1", getStat1());
		model.addAttribute("stat2", getStat2());
		return "exam";		
	}
	
	@RequestMapping(value = "/update")
	public String update (ExamTest examTest) {		
		Optional<ExamTest> optExam = exams.stream().peek(e->System.out.println("id: " +e.getId())).filter(e -> e.getId().equals(e.getId())).findAny(); 
		if(optExam.isPresent()) {
			// updateExam 原本的資料
			// 表單傳來 examTest 要修改的資料
			ExamTest updateExam = optExam.get();
			updateExam.setName(examTest.getName());
			updateExam.setSlot(examTest.getSlot());
			updateExam.setPay(examTest.getPay());
			updateExam.setNote(examTest.getNote());
		}
		
		return "redirect:/mvc/exam/"; // 修改完畢後，重導致首頁	 
	}
	@RequestMapping(value = "/delete/{id}")
	public String delete (@PathVariable("id") String id) {				
		exams.removeIf(e -> e.getId().equals(id)); // removeIf 用法，若刪除成功? true: false
		return "redirect:/mvc/exam/"; // 刪除完畢後，重導致首頁	 
	}	
	
	// 統計資料 1. 各科考試報名人數
	private Map<String, Long> getStat1(){
		Map<String, Long> stat1 = exams.stream()
				   .collect(Collectors.groupingBy(ExamTest::getName, Collectors.counting()));
		return stat1;
	}
	// 統計資料 2. 考試付款狀況
	private Map<String, Long> getStat2() {
		Map<String, Long> stat2 = exams.stream()
				.collect(Collectors.groupingBy(ExamTest::getPay, Collectors.counting()));
		return stat2;
	}
}



package com.mvc.controller;
import java.io.UnsupportedEncodingException;
import java.util.IntSummaryStatistics; 
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mvc.entity.User;


@Controller
//@RequestMapping(value = "/hello")
public class Hello {
	
	
	@RequestMapping(value = "/greet")
	@ResponseBody()
	public String greet() {
		return "你好 Hello to Spring MVC";
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
	
	/*
	 * Lab:
	 * 路徑: /bmi?h=175&w=70
	 * 帶入: h 與 w 二個參數
	 * 結果: bmi = 22.86
	 * 
	 */
	@RequestMapping(value = "/bmi")
	@ResponseBody
	public String bmi(@RequestParam("h") Double h, @RequestParam("w") Double w) {
		double bmi = w / Math.pow(h/100, 2);
		return String.format("bmi = %.2f", bmi);
	}
	
	/*
	 * PathVariable
	 * 路徑: /exam/60 -> 結果: 60 pass
	 * 路徑: /exam/59 -> 結果: 59 fail
	 * 
	 */
	@RequestMapping(value = "/exam/{score}")
	@ResponseBody
	public String exam(@PathVariable("score") Integer score) {
		return score + " " + ((score >= 60)? "Pass" : "Fail");
	}
	
	/*
	 * Lab: PathVariable + RequestParam
	 * 路徑：/calc/add?x=30&y=20  -> 結果：50
	 * 路徑：/calc/sub?x=30&y=20  -> 結果：10
	 * 路徑：/calc/sub?y=20       -> 結果：20
	 * 路徑：/calc/sub?x=0&y=20   -> 結果：-20
	 * 路徑：/calc/add            -> 結果：0
	 * 路徑：/calc/div            -> 結果："None" <- 無此路徑
	 * */
	@RequestMapping(value = "/calc/{exp}")
	@ResponseBody
	public String calc(@PathVariable("exp") String exp,
			           @RequestParam(value = "x", required = false) Optional<Integer> x,
			           @RequestParam(value = "y", required = false) Optional<Integer> y) {				
		if(x.isPresent() && y.isPresent()) {
			switch (exp) {
				case "add":
					return x.get() + y.get() + "";
				case "sub":
					return x.get() - y.get() + "";
				default:
					return "None";
			}
		}
		if(x.isPresent()) {
			return x.get() + "";
		}
		if(y.isPresent()) {
			return y.get() + "";
		}
		return "0";
	}	
	
	/*
	 * 常見的 PathVariable 萬用字元 * 任意多字, ? 任意一字
	 * */
	@RequestMapping(value = "/any/*/java?")
	@ResponseBody
	public String any() {
		return "Any";
	}

	/*
	 * 得到多筆資料
	 * 路徑：/age?a=18&a=19&a=20 
	 * 結果：[18, 19, 20] , age of average = 19
	 * */
	@RequestMapping("/age")
	@ResponseBody
	public String age(@RequestParam("a") List<Integer> ageList) {
		// Java 5 以前，未自動處理 unboxing
		// double avg = ageList.stream().mapToInt(age -> age.intValue()).average().getAsDouble();
		// Java 5 之後，有自動處理 unboxing				
		double avg = ageList.stream().mapToInt(age -> age).average().getAsDouble();
		return String.format("%s , age of average = %d", ageList, (int)avg);
	}

	
	/* Lab
	 * 得到多筆 score 資料
	 * 網址輸入：/max?score=80&score=100&score=50
	 * 網址輸入：/min?score=80&score=100&score=50
	 * 結果得到：max score = 100
	 * 結果得到：min score = 80
	 * 建議使用：IntSummaryStatistics
	 * */
	@RequestMapping("/{opt}")
	@ResponseBody
	public String maxAndMin(@PathVariable("opt") String opt, 
			                @RequestParam("score") List<Integer> scores) {
		String str = "%s score = %d";
		IntSummaryStatistics stat = scores.stream().mapToInt(score -> score).summaryStatistics();
		switch (opt) {
			case "max":				
				str = String.format(str, opt, stat.getMax());
				break;
			case "min":
				str = String.format(str, opt, stat.getMin());
				break;
			default:
				str = "None";
				break;
		}
		return str;
	}
	
	/*
	 * Map 參數
	 * 網址輸入：/mix?name=John&score=100&age=18&pass=true
	 * 網址輸入：/mix?name=Mary&score=90&age=20&level=2
	 * */
	@RequestMapping("/mix")
	@ResponseBody
	public String mix(@RequestParam Map<String, String> map) {
		return map.toString();
	}
	
	/*
	 * Java pojo 物件
	 * 網址輸入：/user?name=John&age=18
	 * */
	@RequestMapping("/user")
	@ResponseBody	
//	public String getUser(@Valid User user) {
	public String getUser(User user) {
		return user.toString();
	}
	
	
	@RequestMapping(value = "/{welcomeChinese}", method = RequestMethod.POST)
	@ResponseBody()
	public String welcomeChinese(@PathVariable("welcomeChinese") String welcomeChinese,
								 @RequestParam("name") String name) {
		// 解決路徑中文問題
		// 預設的編碼是: ISO-8859-1
		// 改變編碼: UTF-8
		try {
			welcomeChinese = new String(welcomeChinese.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return welcomeChinese + " to " + name;
	}
	
}







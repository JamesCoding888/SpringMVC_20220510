package com.mvc.controller;
import javax.validation.Valid;   
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.mvc.entity.products.Product;
import com.mvc.service.ProductService;

@Controller
@RequestMapping(value = "/product")
@SessionAttributes(value = {"groups", "products", "sizes", "levels"})
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = {"/", "/input"})
	public String index(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("groups", productService.groups.values());
		model.addAttribute("products", productService.query());
		model.addAttribute("sizes", productService.sizes.values());
		model.addAttribute("levels", productService.levels.values());
		model.addAttribute("action", "save");	
		return "product";		
	}
	
	@PostMapping(value = "/save") 
	// @RequestMapping(value = "/save", method = RequestMethod.POST) // 等同 @PostMapping(value = "/save") 
	// 若要使用 JSR303 驗證，必須要在驗證資料模組前面加上 @Valid 註釋
	public String save(@Valid Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			/* 因為有配置 @SessionAttributes(value = {"groups", "products"}) ，底下可不寫
			model.addAttribute("groups", productService.groups.values());
			model.addAttribute("products", productService.query());
			*/	
			model.addAttribute("action", "save"); // 不要配置在 @SessionAttributes 中
			return "product"; // 若有錯誤發生，則將錯誤資訊帶給指定 jsp 頁面			
		}
		productService.save(product);		
		return "redirect:/mvc/product/";
	}
	@GetMapping("/get/{name}")
	public String get(@PathVariable("name") String name, Model model) {
		Product product = productService.get(name);
		System.out.println(product);
		model.addAttribute("product", product);
		/* 因為有配置 @SessionAttributes(value = {"groups", "products"}) ，底下可不寫
		model.addAttribute("groups", productService.groups.values());
		model.addAttribute("products", productService.query());
		*/	
		model.addAttribute("action", "update");		
		return "product";
	}
	
	@PostMapping(value = "/update")
	public String update(@Valid Product product, BindingResult result, Model model) {
		System.out.println(product);
		if(result.hasErrors()) {
			model.addAttribute("product", product);			
			model.addAttribute("action", "update");
			return "product";
		}				
		productService.update(product);
		System.out.println(product);
		return "redirect:/mvc/product/";
	}
	
	@GetMapping("/delete/{name}")
	public String delete(@PathVariable("name") String name) {
		productService.delete(name);
		return "redirect:/mvc/product/";
	}
} 

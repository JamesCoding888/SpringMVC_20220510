package com.mvc.validator;
import org.springframework.stereotype.Component;   
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.mvc.entity.ExamTest;
@Component
public class ExamValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// 判定當前 clazz 是不是 ExamTest 的類別		
		return ExamTest.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		ExamTest examTest = (ExamTest)target;
		// 判定 id 不可以是 null 或空的
		if(examTest.getId() == null || examTest.getId().trim().length() == 0) {
			// 說明 rejectValue(field, erroCode, defaultMessage)
			// errorCode : 錯誤名稱(通常是指 errorMessages.properties 所設定的名稱)，若無預設則 null
			// defaultMessage : 預設的錯誤訊息
			errors.rejectValue("id", "examTest.id.required", "id 不可空白");
		}
		if(examTest.getName() == null || examTest.getName().trim().length() == 0) {
			errors.rejectValue("name", "examTest.name.required", "請選擇考試代號");
		}
		if(examTest.getSlot() == null || examTest.getSlot().length == 0) {
			errors.rejectValue("slot", "examTest.slot.required", "請選擇考試時段");
		}
		if(examTest.getPay() == null || examTest.getPay().trim().length() == 0) {
			errors.rejectValue("pay", "examTest.pay.required", "請選擇繳費狀況");
		}
	}
}

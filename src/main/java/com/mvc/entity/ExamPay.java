package com.mvc.entity;
public class ExamPay {
	private String id;
	private String pay;
	public ExamPay() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExamPay(String id, String pay) {
		super();
		this.id = id;
		this.pay = pay;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
}

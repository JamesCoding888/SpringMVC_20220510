package com.mvc.entity;

public class ExamName {
	private String id;
	private String name;
	public ExamName() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ExamName(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

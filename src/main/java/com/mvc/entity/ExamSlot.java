package com.mvc.entity;
public class ExamSlot {
	private String id;
	private String slot;
	public ExamSlot() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExamSlot(String id, String slot) {
		super();
		this.id = id;
		this.slot = slot;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}

}

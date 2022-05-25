package com.mvc.entity;
import java.util.Arrays;  
import java.util.Objects;
public class ExamTest {
	private String id;
	private String name;
	private String[] slot;
	private String pay;
	private String note;
	
	// 將 slot 陣列轉字串使用
	// Ex: ${ e.slotToString }	
	public String getSlotToString() {
		return Arrays.toString(slot);
	}
	
	public String getId() {
		return id;
	}
	public ExamTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setId(String id) {
		this.id = id;
		System.out.println(this.id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println(this.name);
	}
	public String[] getSlot() {
		return slot;
	}
	public void setSlot(String[] slot) {
		this.slot = slot;
		System.out.println("slot: " + this.slot);
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
		System.out.println(this.pay);
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
		System.out.println(this.note);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(slot);
		result = prime * result + Objects.hash(id, name, note, pay);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExamTest other = (ExamTest) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(note, other.note)
				&& Objects.equals(pay, other.pay) && Arrays.equals(slot, other.slot);
	}
	@Override
	public String toString() {
		return "Exam [id=" + id + ", name=" + name + ", slot=" + Arrays.toString(slot) + ", pay=" + pay + ", note="
				+ note + "]";
	}
	
}

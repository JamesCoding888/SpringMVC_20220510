package com.mvc.entity.products;
public class Level {
	private Integer lid;
	private String lname;
	public Level() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Level(Integer lid, String lname) {
		super();
		this.lid = lid;
		this.lname = lname;
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "Level [lid=" + lid + ", lname=" + lname + "]";
	}
	
}

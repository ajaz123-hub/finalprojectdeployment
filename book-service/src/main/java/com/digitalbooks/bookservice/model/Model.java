package com.digitalbooks.bookservice.model;

import java.time.LocalDate;

public class Model {
	private String message;
	private String type;
	private LocalDate date;
	private String desc;
	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Model(String message, String type, LocalDate date, String desc) {
		super();
		this.message = message;
		this.type = type;
		this.date = date;
		this.desc = desc;
	}
	public Model(String message, String type, String desc) {
		super();
		this.message = message;
		this.type = type;
		this.date = LocalDate.now();
		this.desc = desc;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}

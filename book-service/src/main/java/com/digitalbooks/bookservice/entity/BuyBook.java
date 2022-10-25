package com.digitalbooks.bookservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class BuyBook {
	
	@Id
    private int bookId;
	private long generatedId;
    private String bookName;
    private String name;
    private String emailId;
    private String date;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public long getGeneratedId() {
		return generatedId;
	}
	public void setGeneratedId(long generatedId) {
		this.generatedId = generatedId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "BuyBook [bookId=" + bookId + ", generatedId=" + generatedId + ", bookName=" + bookName + ", name="
				+ name + ", emailId=" + emailId + ", date=" + date + "]";
	}
	public BuyBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyBook(int bookId, long generatedId, String bookName, String name, String emailId) {
		super();
		this.bookId = bookId;
		this.generatedId = generatedId;
		this.bookName = bookName;
		this.name = name;
		this.emailId = emailId;
	}
    
    
	

}

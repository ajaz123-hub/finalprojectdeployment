package com.digitalbooks.bookservice.model;

public class AuthorResponse {
	private Object bookData;
	private String exception;
	private String message;
	public Object getBookData() {
		return bookData;
	}
	public void setBookData(Object bookData) {
		this.bookData = bookData;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "AuthorResponse [bookData=" + bookData + ", exception=" + exception + ", message=" + message + "]";
	}
	public AuthorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthorResponse(Object bookData, String exception, String message) {
		super();
		this.bookData = bookData;
		this.exception = exception;
		this.message = message;
	}
	

}

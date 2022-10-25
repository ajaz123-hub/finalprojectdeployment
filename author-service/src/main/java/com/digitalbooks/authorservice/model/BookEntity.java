package com.digitalbooks.authorservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String title;
	private String authorName;
	private int authorId;
	private double price;
	private String publisher;
	private String publishedDate;
	private String category;
	private boolean active;
	private String contents;
	private String updatedDate;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookEntity [bookId=" + bookId + ", title=" + title + ", authorName=" + authorName + ", authorId="
				+ authorId + ", price=" + price + ", publisher=" + publisher + ", publishedDate=" + publishedDate
				+ ", category=" + category + ", active=" + active + ", contents=" + contents + ", updatedDate="
				+ updatedDate + "]";
	}
	public BookEntity(int bookId, String title, String authorName, int authorId, double price, String publisher,
			String publishedDate, String category, boolean active, String contents, String updatedDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.authorName = authorName;
		this.authorId = authorId;
		this.price = price;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.category = category;
		this.active = active;
		this.contents = contents;
		this.updatedDate = updatedDate;
	}
	
	
	

}

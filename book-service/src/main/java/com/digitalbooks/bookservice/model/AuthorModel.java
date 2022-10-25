package com.digitalbooks.bookservice.model;

public class AuthorModel {
	private int aId;
	private String authorEmailId;
	private String username;
	private String password;
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getAuthorEmailId() {
		return authorEmailId;
	}
	public void setAuthorEmailId(String authorEmailId) {
		this.authorEmailId = authorEmailId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AuthorModel [aId=" + aId + ", authorEmailId=" + authorEmailId + ", username=" + username + ", password="
				+ password + "]";
	}
	
	

}

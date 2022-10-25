package com.digitalbooks.authorservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AuthorDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	public AuthorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthorDetails(int aId, String authorEmailId, String username, String password) {
		super();
		this.aId = aId;
		this.authorEmailId = authorEmailId;
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "AuthorDetails [aId=" + aId + ", authorEmailId=" + authorEmailId + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	

}

package com.digitalbooks.authorservice.model;

public class BaseResponse {

	private long statusCode;
	private String statusMessage;
	private AuthorDetails authorDetails;

	public long getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(long statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public AuthorDetails getAuthorDetails() {
		return authorDetails;
	}

	public void setAuthorDetails(AuthorDetails authorDetails) {
		this.authorDetails = authorDetails;
	}

	public BaseResponse(long statusCode, String statusMessage) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	public BaseResponse(long statusCode, String statusMessage, AuthorDetails authorDetails) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.authorDetails = authorDetails;
	}

	public BaseResponse() {
	}

}

package com.example.todo.webservices.resfulwebservices.com.example.todo.basic.auth;

public class BasicAuthenticationBean {

	private String message;

	public BasicAuthenticationBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

}

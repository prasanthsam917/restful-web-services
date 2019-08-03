package com.example.todo.webservices.resfulwebservices.com.example.todo.webservices.resfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedString = encoder.encode("Jesusno@1");
		System.out.println(encodedString);
	}
	
}

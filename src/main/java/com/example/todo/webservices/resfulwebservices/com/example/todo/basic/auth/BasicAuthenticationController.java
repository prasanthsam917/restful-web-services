package com.example.todo.webservices.resfulwebservices.com.example.todo.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthenticationController {

	@GetMapping(path="/basicauth")
	public BasicAuthenticationBean basicAuthentication() {
		//throw new RuntimeException("Some Error has happened! **************");
		return new BasicAuthenticationBean("You are Authenticated");
	}
}

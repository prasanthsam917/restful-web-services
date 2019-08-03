package com.example.todo.webservices.resfulwebservices.com.example.todo.webservices.resfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {

	//method
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		throw new RuntimeException("Some Error has happened! **************");
		//return new HelloWorldBean("Hello World Bean");
	}
	
	@GetMapping(path="/hello-world/path-variable/{usrName}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String usrName) {
		return new HelloWorldBean(String.format("Helooworld!, %s", usrName));
	}
}

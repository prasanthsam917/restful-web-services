package com.example.todo.webservices.resfulwebservices.com.example.todo.webservices.resfulwebservices;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.todo.webservices.resfulwebservices.com.example.todo.webservices.resfulwebservices.todo.TodoHardCodedService;
import com.example.todo.webservices.resfulwebservices.com.example.todo.webservices.resfulwebservices.todo.TodoJpaRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoJpaResources {
	
	@Autowired
	private TodoHardCodedService todoService;
	
	@Autowired
	private TodoJpaRepository todoJpaRepository;
	
	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo>getAllTodos(@PathVariable String username){
		return todoJpaRepository.findByUserName(username);
//		return todoService.findAll();
	}
	
	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo retreiveTodo(@PathVariable String username,@PathVariable long id){
		return todoJpaRepository.findById(id).get();
		//return todoService.findById(id);
	}
	
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		// Todo todo = todoService.deleteById(id);
		todoJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> saveTodo(@PathVariable String username,@PathVariable long id, @RequestBody Todo todo) {
		//Todo updatedTodo = todoService.save(todo);
		Todo updatedTodo = todoJpaRepository.save(todo);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	@PostMapping("/jpa/users/{username}/todos")
	public ResponseEntity<Todo> createdTodo(@PathVariable String username, @RequestBody Todo todo) {
		// Todo createdTodo = todoService.save(todo);
		todo.setUserName(username);
		Todo createdTodo = todoJpaRepository.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}

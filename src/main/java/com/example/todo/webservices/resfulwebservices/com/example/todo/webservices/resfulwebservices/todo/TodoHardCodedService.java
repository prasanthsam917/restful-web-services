package com.example.todo.webservices.resfulwebservices.com.example.todo.webservices.resfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.webservices.resfulwebservices.com.example.todo.webservices.resfulwebservices.Todo;

@Service
public class TodoHardCodedService {

	private static List<Todo> todoList = new ArrayList();
	private static int idCounter = 0;

	static {
		todoList.add(new Todo(++idCounter, "m_sampras", "Learn to java", false, new Date()));
		todoList.add(new Todo(++idCounter, "m_sampras", "Learn to javaScript", false, new Date()));
		todoList.add(new Todo(++idCounter, "m_sampras", "Learn to jenkins", false, new Date()));
		todoList.add(new Todo(++idCounter, "m_sampras", "Learn to Angular", false, new Date()));
	}

	public List<Todo> findAll() {
		return todoList;
	}

	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todo == null)
			return null;
		if (todoList.remove(todo)) {
			return todo;
		}
		return null;
	}

	public Todo findById(long id) {
		for (Todo todo : todoList) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todoList.add(todo);
		}else {
			deleteById(todo.getId());
			todoList.add(todo);
		}
		return todo;
	}
}

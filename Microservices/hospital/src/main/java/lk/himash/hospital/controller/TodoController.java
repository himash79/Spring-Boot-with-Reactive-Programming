package lk.himash.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.himash.hospital.dto.Response;
import lk.himash.hospital.dto.TodoDto;
import lk.himash.hospital.service.TodoService;

@RestController
@RequestMapping("/v1/todoAPI")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/getAllTodos")
	public Response getAllTodos() {
		return todoService.getAllTodos();
	}
	
	@GetMapping("/getTodo/{id}")
	public Response getTodo(@PathVariable String id) {
		return todoService.getTodo(id);
	}
	
	@PostMapping("/addTodo")
	public Response addTodo(@RequestBody TodoDto todoDto) {
		return todoService.addTodo(todoDto);
	}
	
	@DeleteMapping("/removeTodo/{id}")
	public Response removeTodo(@PathVariable String id) {
		return todoService.removeTodo(id);
	}
	
	@PutMapping("/editTodo/{id}")
	public Response removeTodo(@RequestBody TodoDto todoDto, @PathVariable String id) {
		return todoService.editTodoDetail(todoDto, id);
	}
	
}

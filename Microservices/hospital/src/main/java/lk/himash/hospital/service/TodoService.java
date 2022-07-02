package lk.himash.hospital.service;

import lk.himash.hospital.dto.Response;
import lk.himash.hospital.dto.TodoDto;

public interface TodoService {

	Response getAllTodos();
	Response getTodo(String id);
	Response addTodo(TodoDto todoDto);
	Response removeTodo(String id);
	Response editTodoDetail(TodoDto todoDto, String id);
	
}

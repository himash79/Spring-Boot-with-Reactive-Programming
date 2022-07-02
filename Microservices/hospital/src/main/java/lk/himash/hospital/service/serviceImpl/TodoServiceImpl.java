package lk.himash.hospital.service.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lk.himash.hospital.dto.Response;
import lk.himash.hospital.dto.TodoDto;
import lk.himash.hospital.service.TodoService;
import lk.himash.hospital.util.PropertyFileReader;

@Service
public class TodoServiceImpl implements TodoService {

	private static RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public Response getAllTodos() {
		Response res = new Response();
		ResponseEntity<String> result = null;
		HttpHeaders headers = new HttpHeaders();
		ObjectMapper mapper = new ObjectMapper();
		try {
//	        headers.add(HttpHeaders.AUTHORIZATION, jsonReader.getAccesTokenforErpNext().get("token")); If have JWT authentication
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			String url = PropertyFileReader.getPropertyFileData("GET_ALL_TODOS");
			result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
			List<TodoDto> todos = mapper.readValue(result.getBody(), new TypeReference<List<TodoDto>>(){});
			res.setHttpStatus(HttpStatus.FOUND);
			res.setObj(todos);
			res.setMsg("SUCCESS");
		} catch (Exception ex) {
			System.out.println("Exception found on | getAllTodos() method | TodoService.class | ");
			System.out.println(ex.getMessage());
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			res.setObj(null);
			res.setMsg("ERROR");
		}
		return res;
	}

	@Override
	public Response getTodo(String id) {
		Response res = new Response();
		HttpHeaders header = new HttpHeaders();
		try {
			header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<>("parameters", header);
			String url = PropertyFileReader.getPropertyFileData("GET_ALL_TODOS");
			TodoDto result = restTemplate.exchange(url + id, HttpMethod.GET, entity, TodoDto.class).getBody();
			res.setHttpStatus(HttpStatus.FOUND);
			res.setObj(result);
			res.setMsg("SUCCESS");
		}catch(Exception ex) {
			System.out.println("Exception found on | getTodo() method | TodoService.class | ");
			System.out.println(ex.getMessage());
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			res.setObj(null);
			res.setMsg("ERROR");
		}
		return res;
	}

	@Override
	public Response addTodo(TodoDto todoDto) {
		Response res = new Response();
		HttpHeaders header = new HttpHeaders();
		try {
			header.add(HttpHeaders.CONTENT_TYPE, "application/json");
			header.add(HttpHeaders.ACCEPT, "application/json");
			HttpEntity<TodoDto> entity = new HttpEntity<>(todoDto, header);
			String url = PropertyFileReader.getPropertyFileData("GET_ALL_TODOS");
			TodoDto result = restTemplate.exchange(url, HttpMethod.POST, entity, TodoDto.class).getBody();
			res.setHttpStatus(HttpStatus.CREATED);
			res.setObj(result);
			res.setMsg("SUCCESS");
		} catch(Exception ex) {
			System.out.println("Exception found on | addTodo() method | TodoService.class | ");
			System.out.println(ex.getMessage());
			res.setHttpStatus(HttpStatus.BAD_REQUEST);
			res.setObj(null);
			res.setMsg("ERROR");
		}
		return res;
	}

	@Override
	public Response removeTodo(String id) {
		Response res = new Response();
		HttpHeaders header = new HttpHeaders();
		try {
			header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<>("parameters", header);
			String url = PropertyFileReader.getPropertyFileData("GET_ALL_TODOS");
			TodoDto result = restTemplate.exchange(url + id, HttpMethod.DELETE, entity, TodoDto.class).getBody();
			res.setHttpStatus(HttpStatus.OK);
			res.setObj(result);
			res.setMsg("SUCCESS");
		} catch(Exception ex) {
			System.out.println("Exception found on | removeTodo() method | TodoService.class | ");
			System.out.println(ex.getMessage());
			res.setHttpStatus(HttpStatus.BAD_REQUEST);
			res.setObj(null);
			res.setMsg("ERROR");
		}
		return res;
	}

	@Override
	public Response editTodoDetail(TodoDto todoDto, String id) {
		Response res = new Response();
		HttpHeaders header = new HttpHeaders();
		try {
			header.add(HttpHeaders.CONTENT_TYPE, "application/json");
			header.add(HttpHeaders.ACCEPT, "application/json");
			HttpEntity<TodoDto> entity = new HttpEntity<>(todoDto, header);
			String url = PropertyFileReader.getPropertyFileData("GET_ALL_TODOS");
			TodoDto result = restTemplate.exchange(url + id, HttpMethod.PUT, entity, TodoDto.class).getBody();
			res.setHttpStatus(HttpStatus.OK);
			res.setObj(result);
			res.setMsg("SUCCESS");
		}catch(Exception ex) {
			System.out.println("Exception found on | editTodoDetail() method | TodoService.class | ");
			System.out.println(ex.getMessage());
			res.setHttpStatus(HttpStatus.BAD_REQUEST);
			res.setObj(null);
			res.setMsg("ERROR");
		}
		return res;
	}

	
	
}

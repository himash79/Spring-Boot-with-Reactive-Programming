package lk.himash.hospital.service.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import lk.himash.hospital.dto.PostDto;
import lk.himash.hospital.dto.PostUserDto;
import lk.himash.hospital.dto.Response;
import lk.himash.hospital.service.PostService;
import lk.himash.hospital.util.PropertyFileReader;
import reactor.core.publisher.Mono;

@Service
public class PostServiceImpl implements PostService {

	@Override
	public Response getAllPosts() {
		Response res = new Response();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String url = PropertyFileReader.getPropertyFileData("GET_ALL_POSTS");
			WebClient webClient = WebClient.create();
			Mono<Object[]> response = webClient.get().uri(url).accept(MediaType.APPLICATION_JSON).retrieve()
					.bodyToMono(Object[].class).log();
			Object[] objects = response.block();
			List<PostDto> posts = Arrays.stream(objects).map(object -> mapper.convertValue(object, PostDto.class))
					.collect(Collectors.toList());
			res.setHttpStatus(HttpStatus.FOUND);
			res.setObj(posts);
			res.setMsg("SUCCESS");
		} catch (Exception ex) {
			System.out.println("Exception found on | getAllPosts() method | PostServiceImpl.class | ");
			System.out.println(ex.getMessage());
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			res.setObj(null);
			res.setMsg("ERROR");
		}
		return res;
	}

	@Override
	public Response getPost(String id) {
		Response res = new Response();
		ObjectMapper mapper = new ObjectMapper();
		try {
			WebClient webClient = WebClient.create();
			String url = PropertyFileReader.getPropertyFileData("GET_ALL_POSTS");
			Mono<Object> response = webClient.get()
					.uri(url + id)
					.accept(MediaType.APPLICATION_JSON)
					.retrieve()
					.bodyToMono(Object.class);
			Object objects = response.block();
			PostDto post = mapper.convertValue(objects, PostDto.class);
			res.setHttpStatus(HttpStatus.FOUND);
			res.setObj(post);
			res.setMsg("SUCCESS");
		} catch (Exception ex) {
			System.out.println("Exception found on | getPost() method | PostServiceImpl.class | ");
			System.out.println(ex.getMessage());
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			res.setObj(null);
			res.setMsg("ERROR");
		}
		return res;
	}

	@Override
	public Response getRelatedPostComments(String id, String value) {
		Response res = new Response();
		ObjectMapper mapper = new ObjectMapper();
		try {
			WebClient webClient = WebClient.create();
			String url = PropertyFileReader.getPropertyFileData("GET_ALL_POSTS");
			String URI = url.concat(id).concat("/").concat(value).concat("/");
			Mono<Object[]> response = webClient.get().uri(URI).accept(MediaType.APPLICATION_JSON)
					.retrieve().bodyToMono(Object[].class);
			Object[] objects = response.block();
			List<PostUserDto> posts = Arrays.stream(objects).map(postObj -> mapper.convertValue(postObj, PostUserDto.class))
					.collect(Collectors.toList());
			System.out.println(posts);
			res.setHttpStatus(HttpStatus.FOUND);
			res.setObj(posts);
			res.setMsg("SUCCESS");
		} catch (Exception ex) {
			System.out.println("Exception found on | getRelatedPostComments() method | PostServiceImpl.class | ");
			System.out.println(ex.getMessage());
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			res.setObj(null);
			res.setMsg("ERROR");
		}
		return res;
	}

	@Override
	public Response addPost(PostDto postDto) {
		PostDto postDto1 = new PostDto();
//		ObjectMapper mapper = new ObjectMapper();
		Response res = new Response();
		try {
			WebClient webClient = WebClient.create();
			String url = PropertyFileReader.getPropertyFileData("GET_ALL_POSTS");
			postDto1 = webClient.post().uri(url)
					   .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					   .body(Mono.just(postDto), PostDto.class)
					   .retrieve()
					   .bodyToMono(PostDto.class)
					   .block();
			res.setHttpStatus(HttpStatus.CREATED);
			res.setObj(postDto1);
			res.setMsg("SUCCESS");
		}catch(Exception ex) {
			System.out.println("Exception found on | addPost() method | PostServiceImpl.class | ");
			System.out.println(ex.getMessage());
			res.setHttpStatus(HttpStatus.BAD_REQUEST);
			res.setObj(null);
			res.setMsg("ERROR");
		}
		return res;
	}

	@Override
	public Response removePost(String id) {
		Response res = new Response();
		PostDto postDto = new PostDto();
		try {
			WebClient webClient = WebClient.create();
			String url = PropertyFileReader.getPropertyFileData("GET_ALL_POSTS");
			postDto = webClient.delete()
					.uri(url + postDto.getId())
					.accept(MediaType.APPLICATION_JSON)
					.retrieve()
					.bodyToMono(PostDto.class)
					.block();
			
			res.setHttpStatus(HttpStatus.OK);
			res.setObj(postDto);
			res.setMsg("SUCCESS"); 
		} catch(Exception ex) {
			System.out.println("Exception found on | removePost() method | PostServiceImpl.class | ");
			System.out.println(ex.getMessage());
			res.setHttpStatus(HttpStatus.BAD_REQUEST);
			res.setObj(null);
			res.setMsg("ERROR");
		}
		return res;
	}

	@Override
	public Response editPost(PostDto newPostDto, String id) {
		Response res = new Response();
		try {
			WebClient webClient = WebClient.create();
			String url = PropertyFileReader.getPropertyFileData("GET_ALL_POSTS");

			PostDto updatedPost = webClient.put().uri(url + id)
					   .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					   .body(Mono.just(newPostDto), PostDto.class)
					   .retrieve()
					   .bodyToMono(PostDto.class)
					   .block();
			
			res.setHttpStatus(HttpStatus.OK);
			res.setObj(updatedPost);
			res.setMsg("SUCCESS"); 
		} catch(Exception ex) {
			System.out.println("Exception found on | editPost() method | PostServiceImpl.class | ");
			System.out.println(ex.getMessage());
			res.setHttpStatus(HttpStatus.BAD_REQUEST);
			res.setObj(null);
			res.setMsg("ERROR");
		}
		return res;
	}

}

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

import lk.himash.hospital.dto.PostDto;
import lk.himash.hospital.dto.Response;
import lk.himash.hospital.service.PostService;

@RestController
@RequestMapping("/v1/postAPI")
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/getAllPosts")
	public Response getPosts() {
		return postService.getAllPosts();
	}
	
	@GetMapping("/getPost/{id}")
	public Response getPosts(@PathVariable String id) {
		return postService.getPost(id);
	}
	
	@GetMapping("/getPostCommentsRelatedUser/{id}/{value}") // value = comments, ...
	public Response getPosts(@PathVariable String id, @PathVariable String value) {
		return postService.getRelatedPostComments(id, value);
	}
	
	@PostMapping("/addPost") 
	public Response addPost(@RequestBody PostDto postDto) {
		return postService.addPost(postDto);
	}
	
	@DeleteMapping("/removePost/{id}") 
	public Response removePost(@PathVariable String id) {
		return postService.removePost(id);
	}
	
	@PutMapping("/editPost/{id}") 
	public Response editPost(@RequestBody PostDto postDto, @PathVariable String id) {
		return postService.editPost(postDto, id);
	}
	
}

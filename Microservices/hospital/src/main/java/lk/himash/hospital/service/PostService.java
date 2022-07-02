package lk.himash.hospital.service;

import lk.himash.hospital.dto.PostDto;
import lk.himash.hospital.dto.Response;

public interface PostService {

	Response getAllPosts();
	Response getPost(String id);
	Response getRelatedPostComments(String id, String value);
	Response addPost(PostDto postDto);
	Response removePost(String id);
	Response editPost(PostDto postDto, String id);
	
}

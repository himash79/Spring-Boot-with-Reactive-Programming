package lk.himash.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUserDto {

	private String postId;
	private String id;
	private String name;
	private String email;
	private String body;
	
	
}

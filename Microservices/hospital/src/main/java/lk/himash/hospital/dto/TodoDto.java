package lk.himash.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {

	private String userId;
	private String id;
	private String title;
	private String completed;
	
}

package lk.himash.hospital.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
	
	private HttpStatus httpStatus;
	private Object obj;
	private String msg;
	

}

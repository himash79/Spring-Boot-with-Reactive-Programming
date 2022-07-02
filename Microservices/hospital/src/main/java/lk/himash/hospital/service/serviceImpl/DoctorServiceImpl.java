package lk.himash.hospital.service.serviceImpl;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lk.himash.hospital.dto.DoctorDto;
import lk.himash.hospital.dto.Response;
import lk.himash.hospital.service.DoctorService;
import lk.himash.hospital.util.PropertyFileReader;
import reactor.core.publisher.Mono;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Override
	public Response getAllDocDetails() {
		Response res = new Response();
		try {
			WebClient webClient = WebClient.create();
			String url = PropertyFileReader.getPropertyFileData("GET_ALL_DOCTOR_DETAILS");
			res = webClient.get().uri(url).retrieve().bodyToMono(Response.class).block();
		} catch(Exception ex) {
			System.out.println("Exception found on | getDocDetails() method | DoctorService.class | ");
			System.out.println(ex.getMessage());
			return res;
		}
		return res;
	}

	@Override
	public Response getDocDetails(String id) {
		Response res = new Response();
		try {
			WebClient webClient = WebClient.create();
			String url = PropertyFileReader.getPropertyFileData("GET_DOCTOR_DETAILS");
			res = webClient.get().uri(url + id).retrieve().bodyToMono(Response.class).block();
		}catch(Exception ex) {
			System.out.println("Exception found on | getDocDetails() method | DoctorService.class | ");
			System.out.println(ex.getMessage());
			return res;
		}
		return res;
	}

	@Override
	public Response AddDoctor(DoctorDto doctorDto) {
		Response res = new Response();
		try {
			WebClient webClient = WebClient.create();
			String url = PropertyFileReader.getPropertyFileData("ADD_DOCTOR");
			res = webClient.post()
					.uri(url)
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.body(Mono.just(doctorDto), DoctorDto.class)
					.retrieve().bodyToMono(Response.class).block();
		}catch(Exception ex) {
			System.out.println("Exception found on | AddDoctor() method | DoctorService.class | ");
			System.out.println(ex.getMessage());
			return res;
		}
		return res;
	}

	@Override
	public Response removeDoctor(String id) {
		Response res = new Response();
		try {
			WebClient webClient = WebClient.create();
			String url = PropertyFileReader.getPropertyFileData("REMOVE_DOCTOR");
			res = webClient.delete().uri(url + id).retrieve().bodyToMono(Response.class).block();
		}catch(Exception ex) {
			System.out.println("Exception found on | removeDoctor() method | DoctorService.class | ");
			System.out.println(ex.getMessage());
			return res;
		}
		return res;
	}

	@Override
	public Response editDocDetails(DoctorDto doctorDto, String id) {
		Response res = new Response();
		try {
			WebClient webClient = WebClient.create();
			String url = PropertyFileReader.getPropertyFileData("EDIT_DOCTO_DETAILS");
			res = webClient.put()
					.uri(url + id)
					.body(Mono.just(doctorDto), DoctorDto.class)
					.retrieve()
					.bodyToMono(Response.class)
					.block();
		}catch(Exception ex) {
			System.out.println("Exception found on | editDocDetails() method | DoctorService.class | ");
			System.out.println(ex.getMessage());
			return res;
		}
		
		return res;
	}

	@Override
	public Response getDocByMaritalStatus(String param) {
		Response res = new Response();
		try {
			WebClient webClient = WebClient.create();
			String url = PropertyFileReader.getPropertyFileData("GET_DOCTOR_BY_MARITAL_STATUS");
			res = webClient.get().uri(url + param).retrieve().bodyToMono(Response.class).block();
		}catch(Exception ex) {
			System.out.println("Exception found on | getDocByMaritalStatus() method | DoctorService.class | ");
			System.out.println(ex.getMessage());
			return res;
		}
		return res;
	}

	@Override
	public Response getDocByName(String param) { // can use as parameter first_name / last_name / age....
		Response res = new Response();
		try {
			WebClient webClient = WebClient.create();
			String url = PropertyFileReader.getPropertyFileData("GET_DOC_BY_FIRST_NAME"); 
			res = webClient.get().uri(url + param).retrieve().bodyToMono(Response.class).block();
		}catch(Exception ex) {
			System.out.println("Exception found on | getDocByName() method | DoctorService.class | ");
			System.out.println(ex.getMessage());
			return res;
		}
		return res;
	}
	
	
	


}

package lk.himash.hospital.service.serviceImpl;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import lk.himash.hospital.dto.PatientDto;
import lk.himash.hospital.dto.Response;
import lk.himash.hospital.service.PatientService;
import lk.himash.hospital.util.PropertyFileReader;

@Service
public class PatientServiceImpl implements PatientService {

	private static RestTemplate restTemplate = new RestTemplate();

	@Override
	public Response getAllPatientDetails() {
		Response res = new Response();
		ResponseEntity<String> result = null;
		Gson gson = new Gson();
		HttpHeaders headers = new HttpHeaders();
		try {
//	        headers.add(HttpHeaders.AUTHORIZATION, jsonReader.getAccesTokenforErpNext().get("token")); If have JWT authentication
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			String url = PropertyFileReader.getPropertyFileData("GET_ALL_PATIENT_DETAILS");
			result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
			res = gson.fromJson(result.getBody(), Response.class);
		} catch (Exception ex) {
			System.out.println("Exception found on | getAllPatientDetails() method | PatientService.class | ");
			System.out.println(ex.getMessage());
		}
		return res;
	}

	@Override
	public Response getPatientDetails(String id) {
		Response res = new Response();
		ResponseEntity<String> result = null;
		Gson gson = new Gson();
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			String url = PropertyFileReader.getPropertyFileData("GET_PATIENT_DETAILS");
			result = restTemplate.exchange(url + id, HttpMethod.GET, entity, String.class);
			res = gson.fromJson(result.getBody(), Response.class);
		} catch (Exception ex) {
			System.out.println("Exception found on | getPatientDetails() method | PatientService.class | ");
			System.out.println(ex.getMessage());
		}

		return res;
	}

	@Override
	public Response addPatient(PatientDto patientDto) {
		Response res = new Response();
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<String> result = null;
		Gson gson = new Gson();
		try {
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
			headers.add(HttpHeaders.ACCEPT, "application/json");
			HttpEntity<PatientDto> entity = new HttpEntity<>(patientDto, headers);
			String url = PropertyFileReader.getPropertyFileData("ADD_PATIENT");
			result = restTemplate.postForEntity(url, entity, String.class);
			res = gson.fromJson(result.getBody(), Response.class);
		} catch (Exception ex) {
			System.out.println("Exception found on | addPatient() method | PatientService.class | ");
			System.out.println(ex.getMessage());
		}

		return res;
	}

	@Override
	public Response removePatient(String id) {
		Response res = new Response();
		ResponseEntity<String> result = null;
		Gson gson = new Gson();
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			String url = PropertyFileReader.getPropertyFileData("REMOVE_PATIENT");
			result = restTemplate.exchange(url + id, HttpMethod.DELETE, entity, String.class);
			res = gson.fromJson(result.getBody(), Response.class);
		} catch (Exception ex) {
			System.out.println("Exception found on | removePatient() method | PatientService.class | ");
			System.out.println(ex.getMessage());
		}
		return res;
	}

	@Override
	public Response editDetails(PatientDto patientDto, String id) {
		Response res = new Response();
		ResponseEntity<String> result = null;
		Gson gson = new Gson();
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
			headers.add(HttpHeaders.ACCEPT, "application/json");
			HttpEntity<PatientDto> entity = new HttpEntity<>(patientDto, headers);
			String url = PropertyFileReader.getPropertyFileData("EDIT_PATIENT_DETAILS");
			result = restTemplate.exchange(url + id, HttpMethod.PUT, entity, String.class);
			res = gson.fromJson(result.getBody(), Response.class);
		} catch (Exception ex) {
			System.out.println("Exception found on | editDetails() method | PatientService.class | ");
			System.out.println(ex.getMessage());
		}
		return res;
	}

	@Override
	public Response getPatientByName(String orderType) {
		Response res = new Response();
		ResponseEntity<String> result = null;
		Gson gson = new Gson();
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			String url = PropertyFileReader.getPropertyFileData("GET_PATIENT_BY_NAME");
			result = restTemplate.exchange(url + orderType, HttpMethod.GET, entity, String.class);
			res = gson.fromJson(result.getBody(), Response.class);
		} catch (Exception ex) {
			System.out.println("Exception found on | getPatientByName() method | PatientService.class | ");
			System.out.println(ex.getMessage());
		}
		return res;
	}

	@Override
	public Response getPatientByAge(String orderType) {
		Response res = new Response();
		ResponseEntity<String> result = null;
		Gson gson = new Gson();
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			String url = PropertyFileReader.getPropertyFileData("GET_PATIENT_BT_AGE");
			result = restTemplate.exchange(url + orderType, HttpMethod.GET, entity, String.class);
			res = gson.fromJson(result.getBody(), Response.class);
		} catch (Exception ex) {
			System.out.println("Exception found on | getPatientByName() method | PatientService.class | ");
			System.out.println(ex.getMessage());
		}
		return res;
	}

	
	
}

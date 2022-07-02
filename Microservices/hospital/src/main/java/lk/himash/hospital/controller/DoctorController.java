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

import lk.himash.hospital.dto.DoctorDto;
import lk.himash.hospital.dto.Response;
import lk.himash.hospital.service.DoctorService;

@RestController
@RequestMapping("/v1/docAPI")
public class DoctorController {
	
	@Autowired
	private DoctorService docService;
	
	@GetMapping("/getDocDetails")
	public Response getAllDocDetails() {
		return docService.getAllDocDetails();
	}
	
	@GetMapping("/getDocDetails/{id}")
	public Response getDocDetails(@PathVariable String id) {
		return docService.getDocDetails(id);
	}
	
	@PostMapping("/addDocDetails")
	public Response addDocDetails(@RequestBody DoctorDto doctorDto) {
		return docService.AddDoctor(doctorDto);
	}
	
	@DeleteMapping("/removeDocDetails/{id}")
	public Response removeDocDetails(@PathVariable String id) {
		return docService.removeDoctor(id);
	}
	
	@PutMapping("/editDocDetails/{id}")
	public Response editDocDetails(@RequestBody DoctorDto doctorDto, @PathVariable String id) {
		return docService.editDocDetails(doctorDto, id);
	}
	
	@GetMapping("/getDocByMaritalStatus/{param}")
	public Response editDocDetails(@PathVariable String param) {
		return docService.getDocByMaritalStatus(param);
	}
	
	@GetMapping("/getDocByFirstName/{param}")
	public Response getDocByName(@PathVariable String param) {
		return docService.getDocByName(param);
	}
	
	
}

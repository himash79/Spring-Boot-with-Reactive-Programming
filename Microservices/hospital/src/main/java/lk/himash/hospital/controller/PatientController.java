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

import lk.himash.hospital.dto.PatientDto;
import lk.himash.hospital.dto.Response;
import lk.himash.hospital.service.PatientService;

@RestController
@RequestMapping("/v1/paAPI")
public class PatientController {

	@Autowired
	private PatientService paService;

	@GetMapping("/getpatientsDetails")
	public Response getAllPatientDetails() {
		return paService.getAllPatientDetails();
	}

	@GetMapping("/getPatientDetails/{id}")
	public Response getPatientDetails(@PathVariable String id) {
		return paService.getPatientDetails(id);
	}

	@PostMapping("/addPpatient")
	public Response getPatientDetails(@RequestBody PatientDto patientDto) {
		return paService.addPatient(patientDto);
	}

	@DeleteMapping("/removePatient/{id}")
	public Response removePatient(@PathVariable String id) {
		return paService.removePatient(id);
	}

	@PutMapping("/editPatient/{id}")
	public Response editDetails(@RequestBody PatientDto patientDto, @PathVariable String id) {
		return paService.editDetails(patientDto, id);
	}

	@GetMapping("/getPatientByName/{orderType}")
	public Response getPatientByName(@PathVariable String orderType) { // ASC , DESC
		return paService.getPatientByName(orderType);
	}
	
	@GetMapping("/getPatientByAge/{orderType}")
	public Response getPatientByAge(@PathVariable String orderType) { // ASC , DESC
		return paService.getPatientByAge(orderType);
	}

}

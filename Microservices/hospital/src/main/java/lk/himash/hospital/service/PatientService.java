package lk.himash.hospital.service;

import lk.himash.hospital.dto.PatientDto;
import lk.himash.hospital.dto.Response;

public interface PatientService {

	Response getAllPatientDetails();
	Response getPatientDetails(String id);
	Response addPatient(PatientDto patientDto);
	Response removePatient(String id);
	Response editDetails(PatientDto patientDto, String id);
	Response getPatientByName(String orderType);
	Response getPatientByAge(String orderType);
	
}

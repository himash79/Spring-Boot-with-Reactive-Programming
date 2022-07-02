package lk.himash.hospital.service;

import lk.himash.hospital.dto.DoctorDto;
import lk.himash.hospital.dto.Response;

public interface DoctorService {

	Response getAllDocDetails();
	Response getDocDetails(String id);
	Response AddDoctor(DoctorDto doctorDto);
	Response removeDoctor(String id);
	Response editDocDetails(DoctorDto doctorDto, String id);
	Response getDocByMaritalStatus(String param);
	Response getDocByName(String param);
	
}

package lk.himash.doctor.service;

import lk.himash.doctor.util.DoctorDto;
import lk.himash.doctor.util.Response;

public interface DoctorService {

    Response getAllDoctorDetails();
    Response getDoctorDetails(String _id);
    Response addDoctor(DoctorDto doctorDto);
    Response deleteDoctor(String id);
    Response editDoctorDetails(DoctorDto doctorDto, String id);
    Response getDoctorsByMaritalStatus(String mStatus);
    Response getDoctorsByFirstName(String order);

}

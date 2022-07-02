package lk.himash.patient.service;

import lk.himash.patient.util.PatientDto;
import lk.himash.patient.util.Response;

public interface PatientService {

    Response getAllPatientDetails();
    Response getPatientDetails(String id);
    Response addPatient(PatientDto patientDto);
    Response deletePatient(String patient_id);
    Response editPatientDetails(PatientDto patientDto, String id);
    Response getPatientByName(String orderType);
    Response getPatientByAge(String orderType);
}

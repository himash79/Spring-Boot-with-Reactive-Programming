package lk.himash.patient.util;

import lk.himash.patient.model.Patient;

public class EntityConversion {

    public static Patient dtoToEntity(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setPatient_id(patientDto.getPatient_id());
        patient.setFirst_name(patientDto.getFirst_name());
        patient.setLast_name(patientDto.getLast_name());
        patient.setAge(patientDto.getAge());
        patient.setMarital_status(patientDto.getMarital_status());
        patient.setState(patientDto.getState());
        patient.setDisease(patientDto.getDisease());
        return patient;
    }

}

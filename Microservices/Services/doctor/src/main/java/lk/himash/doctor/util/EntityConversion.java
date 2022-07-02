package lk.himash.doctor.util;

import lk.himash.doctor.model.Doctor;

public class EntityConversion {

    public static Doctor dtoToEntity(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.set_id(doctorDto.get_id());
        doctor.setFirst_name(doctorDto.getFirst_name());
        doctor.setLast_name(doctorDto.getLast_name());
        doctor.setAge(doctorDto.getAge());
        doctor.setMarital_status(doctorDto.getMarital_status());
        doctor.setState(doctorDto.getState());
        return doctor;
    }

}

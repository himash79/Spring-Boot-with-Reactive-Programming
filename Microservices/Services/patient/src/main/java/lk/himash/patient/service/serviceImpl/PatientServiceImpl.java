package lk.himash.patient.service.serviceImpl;

import lk.himash.patient.model.Patient;
import lk.himash.patient.repository.PatientRepository;
import lk.himash.patient.service.PatientService;
import lk.himash.patient.util.EntityConversion;
import lk.himash.patient.util.PatientDto;
import lk.himash.patient.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository paRepo;

    @Override
    public Response getAllPatientDetails() {
        List<Patient> patients = new ArrayList<>();
        Response res = new Response();
        try {
            patients = paRepo.findAll();
            System.out.println(patients);
            res.setHttpStatus(HttpStatus.OK);
            res.setObj(patients);
            res.setMsg("SUCCESS");
        }catch(Exception ex) {
            res.setHttpStatus(HttpStatus.NOT_FOUND);
            res.setObj(patients);
            res.setMsg("ERROR");
        }
        return res;
    }

    @Override
    public Response getPatientDetails(String id) {
        Response res = new Response();
        Patient patient;
        try {
            patient = paRepo.findById(id).get();
            res.setHttpStatus(HttpStatus.OK);
            res.setObj(patient);
            res.setMsg("SUCCESS");
        }catch(Exception ex) {
            res.setHttpStatus(HttpStatus.NOT_FOUND);
            res.setObj(ex.getMessage());
            res.setMsg("ERROR");
        }
        return res;
    }

    @Override
    public Response addPatient(PatientDto patientDto) {
        Response res = new Response();
        Patient patient;
        try {
            patient = EntityConversion.dtoToEntity(patientDto);
            patient = paRepo.save(patient);
            res.setHttpStatus(HttpStatus.CREATED);
            res.setObj(patient);
            res.setMsg("SUCCESS");
        }catch(Exception ex) {
            res.setHttpStatus(HttpStatus.BAD_REQUEST);
            res.setObj(ex.getMessage());
            res.setMsg("ERROR");
        }
        return res;
    }

    @Override
    public Response deletePatient(String patient_id) {
        Response res = new Response();
        Patient patient;
        try {
            patient = paRepo.findById(patient_id).get();
            paRepo.delete(patient);
            res.setHttpStatus(HttpStatus.OK);
            res.setObj(patient);
            res.setMsg("SUCCESS");
        }catch(Exception ex) {
            res.setHttpStatus(HttpStatus.BAD_REQUEST);
            res.setObj(ex.getMessage());
            res.setMsg("ERROR");
        }
        return res;
    }

    @Override
    public Response editPatientDetails(PatientDto patientDto, String id) {
        Response res = new Response();
        Patient oldPaObj, newPaObj, updatedPaObj;
        try {
            oldPaObj = paRepo.findById(id).get();
            newPaObj = EntityConversion.dtoToEntity(patientDto);
            updatedPaObj = setNewDoctorDetails(oldPaObj, newPaObj);
            paRepo.save(updatedPaObj);
            res.setHttpStatus(HttpStatus.CREATED);
            res.setMsg("SUCCESS");
            res.setObj(updatedPaObj);
        }catch(Exception ex) {
            res.setHttpStatus(HttpStatus.BAD_REQUEST);
            res.setObj(ex.getMessage());
            res.setMsg("ERROR");
        }
        return res;
    }

    private static Patient setNewDoctorDetails(Patient oldPaObj, Patient newPaObj) {
        oldPaObj.setFirst_name(newPaObj.getFirst_name());
        oldPaObj.setLast_name(newPaObj.getLast_name());
        oldPaObj.setAge(newPaObj.getAge());
        oldPaObj.setMarital_status(newPaObj.getMarital_status());
        oldPaObj.setState(newPaObj.getState());
        oldPaObj.setDisease(newPaObj.getDisease());
        return oldPaObj;
    }

    @Override
    public Response getPatientByName(String orderType) {
        Response res = new Response();
        List<Patient> patients = new ArrayList();
        try {
            if(orderType.equalsIgnoreCase("ASC")) {
                patients = paRepo.getPatientByNameASC();
                res.setHttpStatus(HttpStatus.FOUND);
                res.setMsg("SUCCESS");
                res.setObj(patients);
            } else if(orderType.equalsIgnoreCase("DESC")) {
                patients = paRepo.getPatientByNameDESC();
                res.setHttpStatus(HttpStatus.FOUND);
                res.setMsg("SUCCESS");
                res.setObj(patients);
            } else {
                res.setHttpStatus(HttpStatus.NOT_FOUND);
                res.setMsg("ERROR");
                res.setObj(patients);
            }
        }catch(Exception ex) {
            res.setHttpStatus(HttpStatus.NOT_FOUND);
            res.setObj(ex.getMessage());
            res.setMsg("ERROR");
        }
        return res;
    }

    @Override
    public Response getPatientByAge(String orderType) {
        Response res = new Response();
        List<Patient> patients = new ArrayList();
        try {
            if(orderType.equalsIgnoreCase("ASC")) {
                patients = paRepo.getPatientByAgeASC();
                res.setHttpStatus(HttpStatus.FOUND);
                res.setMsg("SUCCESS");
                res.setObj(patients);
            } else if(orderType.equalsIgnoreCase("DESC")) {
                patients = paRepo.getPatientByAgeDESC();
                res.setHttpStatus(HttpStatus.FOUND);
                res.setMsg("SUCCESS");
                res.setObj(patients);
            } else {
                res.setHttpStatus(HttpStatus.NOT_FOUND);
                res.setMsg("ERROR");
                res.setObj(patients);
            }
        }catch(Exception ex) {
            res.setHttpStatus(HttpStatus.NOT_FOUND);
            res.setObj(ex.getMessage());
            res.setMsg("ERROR");
        }
        return res;
    }
}

package lk.himash.doctor.service.serivceImpl;

import lk.himash.doctor.model.Doctor;
import lk.himash.doctor.repository.DoctorRepository;
import lk.himash.doctor.service.DoctorService;
import lk.himash.doctor.util.DoctorDto;
import lk.himash.doctor.util.EntityConversion;
import lk.himash.doctor.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository docRepo;

    @Override
    public Response getAllDoctorDetails() {
        List<Doctor> docs = new ArrayList<>();
        Response res = new Response();
        try {
            docs = docRepo.findAll();
            res.setHttpStatus(HttpStatus.OK);
            res.setObj(docs);
            res.setMsg("SUCCESS");
        }catch(Exception ex) {
            res.setHttpStatus(HttpStatus.NOT_FOUND);
            res.setObj(docs);
            res.setMsg("ERROR");
        }
        return res;
    }

    @Override
    public Response getDoctorDetails(String _id) {
        Response res = new Response();
        Doctor doc;
        try {
            doc = docRepo.findById(_id).get();
            res.setHttpStatus(HttpStatus.OK);
            res.setObj(doc);
            res.setMsg("SUCCESS");
        }catch(Exception ex) {
            res.setHttpStatus(HttpStatus.NOT_FOUND);
            res.setObj(ex.getMessage());
            res.setMsg("ERROR");
        }
        return res;
    }

    @Override
    public Response addDoctor(DoctorDto doctorDto) {
        Response res = new Response();
        Doctor doc;
        try {
            doc = EntityConversion.dtoToEntity(doctorDto);
            doc = docRepo.save(doc);
            res.setHttpStatus(HttpStatus.CREATED);
            res.setObj(doc);
            res.setMsg("SUCCESS");
        }catch(Exception ex) {
            res.setHttpStatus(HttpStatus.BAD_REQUEST);
            res.setObj(ex.getMessage());
            res.setMsg("ERROR");
        }
        return res;
    }

    @Override
    public Response deleteDoctor(String id) {
        Response res = new Response();
        Doctor doc;
        try {
            doc = docRepo.findById(id).get();
            docRepo.delete(doc);
            res.setHttpStatus(HttpStatus.OK);
            res.setObj(doc);
            res.setMsg("SUCCESS");
        }catch(Exception ex) {
            res.setHttpStatus(HttpStatus.BAD_REQUEST);
            res.setObj(ex.getMessage());
            res.setMsg("ERROR");
        }
        return res;
    }

    @Override
    public Response editDoctorDetails(DoctorDto newDoctorDto, String id) {
        Response res = new Response();
        Doctor oldDocObj, newDocObj, updatedDocObj;
        try {
            oldDocObj = docRepo.findById(id).get();
            newDocObj = EntityConversion.dtoToEntity(newDoctorDto);
            updatedDocObj = setNewDoctorDetails(oldDocObj, newDocObj);
            docRepo.save(updatedDocObj);
            res.setHttpStatus(HttpStatus.CREATED);
            res.setMsg("SUCCESS");
            res.setObj(updatedDocObj);
        }catch(Exception ex) {
            res.setHttpStatus(HttpStatus.BAD_REQUEST);
            res.setObj(ex.getMessage());
            res.setMsg("ERROR");
        }
        return res;
    }

    private static Doctor setNewDoctorDetails(Doctor oldDocObj, Doctor newDocObj) {
        oldDocObj.setFirst_name(newDocObj.getFirst_name());
        oldDocObj.setLast_name(newDocObj.getLast_name());
        oldDocObj.setAge(newDocObj.getAge());
        oldDocObj.setMarital_status(newDocObj.getMarital_status());
        oldDocObj.setState(newDocObj.getState());
        return oldDocObj;
    }

    @Override
    public Response getDoctorsByMaritalStatus(String mStatus) {
        Response res = new Response();
        List<Doctor> doctors;
        try {
            doctors = docRepo.getDoctorRelatedMaritalStatus(mStatus);
            res.setHttpStatus(HttpStatus.FOUND);
            res.setMsg("SUCCESS");
            res.setObj(doctors);
        }catch(Exception ex) {
            res.setHttpStatus(HttpStatus.NOT_FOUND);
            res.setObj(ex.getMessage());
            res.setMsg("ERROR");
        }
        return res;
    }

    @Override
    public Response getDoctorsByFirstName(String order) {
        Response res = new Response();
        List<Doctor> doctors;
        try {
            doctors = docRepo.findAll(Sort.by(Sort.Direction.ASC, order));
            System.out.println("doctor : " + doctors);
            res.setHttpStatus(HttpStatus.FOUND);
            res.setMsg("SUCCESS");
            res.setObj(doctors);
        }catch(Exception ex) {
            res.setHttpStatus(HttpStatus.NOT_FOUND);
            res.setObj(ex.getMessage());
            res.setMsg("ERROR");
        }
        return res;
    }
}

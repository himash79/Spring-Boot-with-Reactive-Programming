package lk.himash.patient.controller;

import lk.himash.patient.service.PatientService;
import lk.himash.patient.util.PatientDto;
import lk.himash.patient.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patientApi")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientService paService;

    @GetMapping("/getAllPaDetails")
    private Response getAllPatientDetails() {
        return paService.getAllPatientDetails();
    }

    @GetMapping("/getPaDetails/{id}")
    public Response getPatientDetails(@PathVariable String id) {
        return paService.getPatientDetails(id);
    }

    @PostMapping("/addPatient")
    public Response addPatient(@RequestBody PatientDto patientDto) {
        return paService.addPatient(patientDto);
    }

    @DeleteMapping("/removePatient/{id}")
    public Response removePatient(@PathVariable String id) {
        return paService.deletePatient(id);
    }

    @PutMapping("/editPatientDetails/{id}")
    public Response editPatientDetails(@RequestBody PatientDto patientDto, @PathVariable String id) {
        return paService.editPatientDetails(patientDto,id);
    }

    @GetMapping("/getPatientByName/{orderType}")
    private Response getPatientByName(@PathVariable String orderType) {
        return paService.getPatientByName(orderType);
    }

    @GetMapping("/getPatientByAge/{orderType}")
    private Response getPatientByAge(@PathVariable String orderType) {
        return paService.getPatientByAge(orderType);
    }
}

package lk.himash.doctor.controller;

import lk.himash.doctor.service.DoctorService;
import lk.himash.doctor.util.DoctorDto;
import lk.himash.doctor.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/docApi")
@CrossOrigin(origins = "*")
public class DoctorController {

    @Autowired
    private DoctorService docService;

    @GetMapping("/getAllDocDetails")
    private Response getAllDocDetails() {
        return docService.getAllDoctorDetails();
    }

    @GetMapping("/getDocDetails/{id}")
    public Response getDocDetails(@PathVariable String id) {
        return docService.getDoctorDetails(id);
    }

    @PostMapping("/addDoctor")
    public Response addDoctor(@RequestBody DoctorDto doctorDto) {
        return docService.addDoctor(doctorDto);
    }

    @DeleteMapping("/removeDoctor/{id}")
    public Response removeDoctor(@PathVariable String id) {
        return docService.deleteDoctor(id);
    }

    @PutMapping("/editDoctorDetails/{id}")
    public Response editDoctorDetails(@RequestBody DoctorDto doctorDto, @PathVariable String id) {
        return docService.editDoctorDetails(doctorDto,id);
    }

    @GetMapping("/getDoctorsByMaritalStatus/{mStatus}")
    public Response getDoctorsByMaritalStatus(@PathVariable String mStatus) {
        return docService.getDoctorsByMaritalStatus(mStatus);
    }

    @GetMapping("/getDoctorsByFirstName/{order}")
    public Response getDoctorsByFirstName(@PathVariable String order) {
        return docService.getDoctorsByFirstName(order);
    }

}

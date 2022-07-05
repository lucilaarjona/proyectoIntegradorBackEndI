package com.dh.dentalClinic.controller;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.persistence.entities.Patient;
import com.dh.dentalClinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {


    @Autowired
    PatientService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Patient p) throws BadRequestException{
        ResponseEntity<String> response = null;

        if(service.save(p) != null) {
            response = ResponseEntity.ok("Patient created.");
        } else {
            response = ResponseEntity.internalServerError().body("Oops");
        }
        return response;
    }

    @GetMapping
    public List<Patient> getAll() throws BadRequestException{
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable Long id) throws BadRequestException {
        return service.getById(id);
    }

    @DeleteMapping(value = "{id}")
    public String delete(@PathVariable Long id) throws BadRequestException{
        return service.delete(id);
    }

    @PutMapping
    public String update(@RequestBody Patient p) throws BadRequestException{
        return service.updatePatient(p);
    }

}

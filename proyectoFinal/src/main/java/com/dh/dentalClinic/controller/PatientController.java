package com.dh.dentalClinic.controller;

import com.dh.dentalClinic.persistence.entities.Dentist;
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

    @PostMapping("")
    public ResponseEntity<String> createPatient(@RequestBody Patient p) {
        ResponseEntity<String> response = null;

        if(service.save(p) != null) {
            response = ResponseEntity.ok("Patient created.");
        } else {
            response = ResponseEntity.internalServerError().body("Oops");
        }
        return response;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public List<Patient> getAllPatients() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping(value = "{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping(value = "")
    public String updateProduct(@RequestBody Patient patient){
        return service.updatePatient(patient);
    }


}

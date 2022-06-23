package com.dh.dentalClinic.controller;

import com.dh.dentalClinic.persistence.entities.Patient;
import com.dh.dentalClinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService service;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Patient p) {
        ResponseEntity<String> response = null;

        if(service.save(p) != null) {
            response = ResponseEntity.ok("Patient created.");
        } else {
            response = ResponseEntity.internalServerError().body("Oops");
        }
        return response;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<Patient> getProduct() {
        return service.getAll();
    }
}

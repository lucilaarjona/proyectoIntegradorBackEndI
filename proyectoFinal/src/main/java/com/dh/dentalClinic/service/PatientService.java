package com.dh.dentalClinic.service;


import com.dh.dentalClinic.persistence.entities.Patient;
import com.dh.dentalClinic.persistence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository repository;
    public String save (Patient p){
        if (repository.save(p)!= null){
            return "OK";
        }else {
            return null;
        }
    }
    public List<Patient> getAll() {
        return repository.findAll();
    }
}

package com.dh.dentalClinic.service;

import com.dh.dentalClinic.persistence.entities.Dentist;
import com.dh.dentalClinic.persistence.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DentistService {
    @Autowired
    DentistRepository repository;

    public String save(Dentist d){
        if (repository.save(d)!= null){
            return "Ok";
        }else {
            return null;
        }
    }
    public List<Dentist> getAll(){
        return repository.findAll();
    }

}

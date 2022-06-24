package com.dh.dentalClinic.service;

import com.dh.dentalClinic.persistence.entities.Appointment;
import com.dh.dentalClinic.persistence.repository.AppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentsRepository repository;
    public String save (Appointment a){
        if (repository.save(a)!=null){
            return "Ok";
        }else{
            return null;
        }
    }
    public List<Appointment> getAll(){
        return repository.findAll();
    }
}

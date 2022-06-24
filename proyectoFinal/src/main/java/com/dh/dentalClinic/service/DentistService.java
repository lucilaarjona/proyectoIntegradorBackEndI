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

    public String delete(Long id) {
        if(repository.findById(id).isPresent()){
            String productName = repository.getById(id).getLastName();
            repository.deleteById(id);
            return "Dentista id: " + id + ", Apellido: " + productName + " fué eliminado.";
        }
        return "Dentista id: " + id + " no fué encontrado.";
    }
    public String updateDentist(Dentist d){
        Long dentistId = d.getId();

        if(repository.findById(dentistId).isPresent()) {
            Dentist dentistaAModificar = repository.getById(dentistId);

            dentistaAModificar.setFirstName(d.getFirstName());
            dentistaAModificar.setLastName(d.getLastName());
            dentistaAModificar.setRegistration(d.getRegistration());

            // no toy segura de este
            // dentistaAModificar.setPatients(d.getPatients());

            repository.save(dentistaAModificar);
            return "Dentist with Id: " + dentistId + " was modified.";

        } else {
            return "Dentist with Id " + dentistId + " does not exist.";
        }
    }
}

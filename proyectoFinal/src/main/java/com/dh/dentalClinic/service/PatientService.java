package com.dh.dentalClinic.service;


import com.dh.dentalClinic.persistence.entities.Patient;
import com.dh.dentalClinic.persistence.repository.PatientRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private static final Logger logger = Logger.getLogger(PatientService.class);

    @Autowired
    PatientRepository repository;

    public String save (Patient p){
        if (repository.save(p)!= null){
            logger.info("Patient was succesfully saved");
            return "OK";
        }else {
            logger.error("There was something wrong...");
            return null;
        }
    }


    public List<Patient> getAll() {
        logger.info("Searching all patients...");
        return repository.findAll();
    }

    public Patient getById(Long id){
        if(repository.existsById(id)){
            Patient patient = repository.findById(id).get();
            logger.info("Looking for patient with id:" + id);
            return patient;
        }
        logger.error("Patient was not found");
        return null;
    }

    public String delete(Long id) {
        if(repository.findById(id).isPresent()){
            //String productName = repository.findById(id).getLastName();
            repository.deleteById(id);

            logger.info("Patient was succesfully deleted");
            //return "Patient id: " + id + ", lastName: " + productName + " was deleted.";
            return "Patient id: " + id + " was deleted.";
        }
        logger.error("Patient was not found");
        return "Patient id: " + id + " was not found.";
    }


    public String updatePatient(Patient p){
        Long patientId = p.getId();

        if(repository.findById(patientId).isPresent()) {
            /*logger.info(repository.getById(p.getAddress().getId()));*/
            Patient pacienteAModificar = repository.findById(patientId).get();
            pacienteAModificar.setFirstName(p.getFirstName());
            pacienteAModificar.setLastName(p.getLastName());
            pacienteAModificar.setDni(p.getDni());
            pacienteAModificar.setAdmissionDate(p.getAdmissionDate());
            pacienteAModificar.setAddress(p.getAddress());

            repository.save(pacienteAModificar);

            logger.info("Patient " + patientId +" was succesfully modified.");
            return "Patient with Id: " + patientId + " was modified.";
        } else {
            logger.error("Patient doesn't exist");
            return "Patient with Id: " + patientId + " doesn't exist.";
        }
    }
}

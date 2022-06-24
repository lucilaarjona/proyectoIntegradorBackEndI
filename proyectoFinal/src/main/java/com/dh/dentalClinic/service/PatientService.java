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

     public String delete(Long id) {
        if(repository.findById(id).isPresent()){
            String productName = repository.getById(id).getLastName();
            repository.deleteById(id);
            return "Paciente id: " + id + ", Apellido: " + productName + " fué eliminado.";
        }
        return "Paciente id: " + id + " no fué encontrado.";
    }
    public String updatePatient(Patient p){
        Long patientId = p.getId();

        if(repository.findById(patientId).isPresent()) {
            Patient pacienteAModificar = repository.getById(patientId);

            pacienteAModificar.setFirstName(p.getFirstName());
            pacienteAModificar.setLastName(p.getLastName());
            pacienteAModificar.setDni(p.getDni());
            pacienteAModificar.setAdmissionDate(p.getAdmissionDate());
            pacienteAModificar.setAddress(p.getAddress());
            pacienteAModificar.setDentist(p.getDentist());

            repository.save(pacienteAModificar);
            return "El paciente con Id: " + patientId + " fué modificado.";

        } else {
            return "El paciente con Id: " + patientId + " no existe.";
        }
    }
}

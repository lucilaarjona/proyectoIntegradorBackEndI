package com.dh.dentalClinic.service;
import com.dh.dentalClinic.persistence.entities.Patient;
import com.dh.dentalClinic.persistence.repository.PatientRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
            repository.deleteById(id);

            logger.info("Patient was succesfully deleted");
            return "Patient id: " + id + ", lastName: " +  " was deleted.";
        }
        logger.error("Patient was not found");
        return "Patient id: " + id + " was not found.";
    }

    public String updatePatient(Patient p){
        Long id = p.getId();

        if(repository.findById(id).isPresent()) {
            Patient modifiedP = repository.findById(id).get();
            modifiedP.setFirstName(p.getFirstName());
            modifiedP.setLastName(p.getLastName());
            modifiedP.setDni(p.getDni());
            modifiedP.setAdmissionDate(p.getAdmissionDate());
            modifiedP.setAddress(p.getAddress());
            modifiedP.setDentist(p.getDentist());

            repository.save(modifiedP);

            logger.info("Patient " + id +" was succesfully modified.");
            return "Patient with Id: " + id + " was modified.";
        } else {
            logger.error("Patient doesn't exist");
            return "Patient with Id: " + id + " doesn't exist.";
        }
    }
}

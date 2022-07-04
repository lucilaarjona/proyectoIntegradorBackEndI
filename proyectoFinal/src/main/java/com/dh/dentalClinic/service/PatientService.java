package com.dh.dentalClinic.service;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.exceptions.GlobalExceptions;
import com.dh.dentalClinic.persistence.entities.Patient;
import com.dh.dentalClinic.persistence.repository.PatientRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService extends GlobalExceptions {

    private static final Logger logger = Logger.getLogger(PatientService.class);

    @Autowired
    PatientRepository repository;

    public String save (Patient p) throws BadRequestException {
        if (repository.save(p)!= null){
            logger.info("Patient was succesfully saved");
            return "New patient succesfully saved";
        } else {
            logger.error("There was something wrong...");
            throw new BadRequestException("There was something wrong...");
        }
    }

    public List<Patient> getAll() throws BadRequestException{
        logger.info("Searching all patients...");
        if (repository.findAll().size()== 0) {
            throw new BadRequestException("There aren't any patients created yet.");
        }
        return repository.findAll();
    }

    public Patient getById(Long id) throws BadRequestException{
        if(repository.existsById(id)){
            Patient patient = repository.findById(id).get();
            logger.info("Looking for patient with id:" + id);
            return patient;
        }
        logger.error("Patient id: " + id + " was not found.");
        throw new BadRequestException("Patient id: " + id + " was not found.");
    }

    public String delete(Long id) throws BadRequestException{
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);

            logger.info("Patient was succesfully deleted");
            return "Patient id: " + id + " was deleted.";
        }
        logger.error("Patient id: " + id + " was not found.");
        throw new BadRequestException("Patient id: " + id + " was not found.");
    }

    public String updatePatient(Patient p) throws BadRequestException{
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
            throw new BadRequestException("Patient with id " + id + " doesn't exist");
        }
    }
}

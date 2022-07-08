package com.dh.dentalClinic.dentalClinicAPI.service;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.exceptions.GlobalExceptions;
import com.dh.dentalClinic.dentalClinicAPI.persistence.entities.Patient;
import com.dh.dentalClinic.dentalClinicAPI.persistence.repository.PatientRepository;
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
            logger.info("Patient was successfully saved");
            return "New patient successfully saved";
        } else {
            logger.error(new BadRequestException("There was something wrong..."));
            throw new BadRequestException("There was something wrong...");
        }
    }

    public List<Patient> getAll() throws BadRequestException{
        logger.info("Searching all patients...");
        if (repository.findAll().size()== 0) {
            logger.error(new BadRequestException("Looking for a non existent list of patients."));
            throw new BadRequestException("There aren't any patients created yet.");
        }
        logger.info("Search completed.");
        return repository.findAll();
    }

    public Patient getById(Long id) throws BadRequestException{
        if(repository.existsById(id)){
            Patient patient = repository.findById(id).get();
            logger.info("Looking for patient with id: " + id);
            return patient;
        }
        logger.error(new BadRequestException("Patient  with id: " + id + " doesn't exist."));
        throw new BadRequestException("Patient id: " + id + " doesn't exist.");
    }

    public String delete(Long id) throws BadRequestException{
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);

            logger.info("Patient with id: " + id + " was deleted.");
            return "Patient with id: " + id + " was deleted.";
        }
        logger.error(new BadRequestException("Patient with id: " + id + " doesn't exist."));
        throw new BadRequestException("Patient id: " + id + " doesn't exist.");
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

            logger.info("Patient with id: " + id +" was successfully modified.");
            return "Patient with id: " + id + " was modified.";
        } else {
            logger.error(new BadRequestException("Patient with id: " + id + " doesn't exist"));;
            throw new BadRequestException("Patient with id:" + id + " doesn't exist");
        }
    }
}

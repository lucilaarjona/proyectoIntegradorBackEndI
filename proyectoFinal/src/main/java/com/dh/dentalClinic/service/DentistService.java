package com.dh.dentalClinic.service;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.exceptions.GlobalExceptions;
import com.dh.dentalClinic.persistence.entities.Dentist;
import com.dh.dentalClinic.persistence.repository.DentistRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DentistService extends GlobalExceptions {

    private static final Logger logger = Logger.getLogger(DentistService.class);

    @Autowired
    DentistRepository repository;

    public String save(Dentist d) throws BadRequestException{
        if (repository.save(d)!= null){
            logger.info("Dentist was succesfully saved");
            return "New dentist succesfully saved";
        }else {
            logger.error("There was something wrong...");
            throw new BadRequestException("There was something wrong...");
        }
    }

    public List<Dentist> getAll() throws BadRequestException{
        logger.info("Searching all dentists...");
        if (repository.findAll().size()== 0) {
            throw new BadRequestException("There aren't any dentists created yet.");
        }
        return repository.findAll();
    }

    public Dentist getById(Long id) throws BadRequestException{

        if(repository.existsById(id)){
            Dentist dentist = repository.findById(id).get();
            logger.info("Looking for dentist with id:" + id);
            return dentist;
        }
        logger.info("Dentist with id " + id + " was not found.");
        throw new BadRequestException("Dentist with id " + id + " was not found.");

    }

        public String delete(Long id) throws BadRequestException {

        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            logger.info("Dentist was succesfully deleted");
            return "Dentist was succesfully deleted";
        }else{
        logger.error("Dentist with id " + id + " was not found.");
        throw new BadRequestException("Dentist with id " + id + " was not found.");
        }
    }

    public String updateDentist(Dentist d) throws BadRequestException{
        Long id = d.getId();

        if(repository.findById(id).isPresent()) {
            Dentist modifiedD = repository.findById(id).get();
            modifiedD.setFirstName(d.getFirstName());
            modifiedD.setLastName(d.getLastName());
            modifiedD.setRegistration(d.getRegistration());
            modifiedD.setPatients(d.getPatients());

            repository.save(modifiedD);
            logger.info("Dentist " + id +" was succesfully modified.");
            return "Dentist with Id: " + id + " was modified.";

        } else {
            logger.error("Dentist with id " + id + " doesn't exist");
            throw new BadRequestException("Dentist with id " + id + " doesn't exist");
        }
    }
}

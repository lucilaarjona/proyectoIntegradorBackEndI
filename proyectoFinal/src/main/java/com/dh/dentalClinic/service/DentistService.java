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
            logger.info("Dentist was successfully saved");
            return "New dentist successfully saved";
        }else {
            logger.error(new BadRequestException("There was something wrong..."));
            throw new BadRequestException("There was something wrong...");
        }
    }

    public List<Dentist> getAll() throws BadRequestException{
        logger.info("Searching all dentists...");
        if (repository.findAll().size()== 0) {
            logger.error(new BadRequestException("Looking for a non existent list of dentists."));
            throw new BadRequestException("There aren't any dentists created yet.");
        }
        logger.info("Search completed.");
        return repository.findAll();
    }

    public Dentist getById(Long id) throws BadRequestException{

        if(repository.existsById(id)){
            Dentist dentist = repository.findById(id).get();
            logger.info("Looking for dentist with id: " + id);
            return dentist;
        }
        logger.error(new BadRequestException("Dentist with id: " + id + " doesn't exist."));
        throw new BadRequestException("Dentist with id: " + id + " doesn't exist.");
    }

        public String delete(Long id) throws BadRequestException {

        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            logger.info("Dentist with id: " + id + " was deleted.");
            return "Dentist with id: " + id + " was deleted.";
        }else{
        logger.error(new BadRequestException("Dentist with id: " + id + " doesn't exist."));
        throw new BadRequestException("Dentist with id: " + id + " doesn't exist.");
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
            logger.info("Dentist with id: " + id +" was successfully modified.");
            return "Dentist with id: " + id + " was modified.";
        } else {
            logger.error(new BadRequestException("Dentist with id: " + id + " doesn't exist"));
            throw new BadRequestException("Dentist with id: " + id + " doesn't exist");
        }
    }
}

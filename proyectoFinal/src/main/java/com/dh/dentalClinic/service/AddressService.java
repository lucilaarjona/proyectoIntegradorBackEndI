package com.dh.dentalClinic.service;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.exceptions.GlobalExceptions;
import com.dh.dentalClinic.persistence.entities.Address;
import com.dh.dentalClinic.persistence.repository.AddressRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressService extends GlobalExceptions {

    private static final Logger logger = Logger.getLogger(AddressService.class);

    @Autowired
    AddressRepository repository;

    public Address save(Address a) throws BadRequestException {
        logger.info("Address was successfully saved");
        return repository.save(a);
    }

    public List<Address> getAll() throws BadRequestException{
        logger.info("Searching all addresses...");
        if (repository.findAll().size()== 0) {
            logger.error(new BadRequestException("Looking for a non existent list of addresses."));
            throw new BadRequestException("There aren't any addresses created yet.");
        }
        logger.info("Search completed.");
        return repository.findAll();

    }

    public Address getById(Long id) throws BadRequestException{

        if(repository.existsById(id)){
            Address address = repository.findById(id).get();
            logger.info("Looking for address with id: " + id);
            return address;
        }
        logger.error(new BadRequestException("Address with id: " + id + " doesn't exist."));
        throw new BadRequestException("Address with id: " + id + " doesn't exist.");
    }

    public String delete(Long id) throws BadRequestException{
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            logger.info("Address was successfully deleted");
            return "Address with id: "+ id + " was deleted. ";
        }
        logger.error(new BadRequestException("Address with id: " + id + " was not found."));
        throw new BadRequestException("Address with id: " + id + " was not found.");
    }

    public String updateAppointment(Address a) throws BadRequestException{
        Long id = a.getId();

        if(repository.findById(id).isPresent()) {
            Address modifiedA = repository.findById(id).get();

            modifiedA.setStreet(a.getStreet());
            modifiedA.setNumber(a.getNumber());
            modifiedA.setLocality(a.getLocality());
            modifiedA.setProvince(a.getProvince());

            repository.save(modifiedA);
            logger.info("Address with id: " + id + " was modified.");
            return "Address with id: " + id + " was modified.";

        } else {
            logger.error(new BadRequestException("Address with id: " + id + " doesn't exist"));
            throw new BadRequestException("Address with id: " + id + " doesn't exist");
        }
    }
}

package com.dh.dentalClinic.service;
import com.dh.dentalClinic.persistence.entities.Address;
import com.dh.dentalClinic.persistence.entities.Appointment;
import com.dh.dentalClinic.persistence.repository.AddressRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressService {

    private static final Logger logger = Logger.getLogger(AddressService.class);

    @Autowired
    AddressRepository repository;

    public String save(Address a){
        if (repository.save(a)!= null){
            logger.info("Address was succesfully saved");
            return "OK";
        }else{
            logger.error("There was something wrong...");
            return null;
        }
    }

    public List<Address> getAll(){
        logger.info("Searching all addresses...");
        return repository.findAll();
    }

    public Address getById(Long id){

        if(repository.existsById(id)){
            Address address = repository.findById(id).get();
            logger.info("Looking for address with id:" + id);
            return address;
        }
        logger.info("Address was not found");
        return null;
    }

    public String delete(Long id) {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            logger.info("Address was succesfully deleted");
            return "Address with id"+ id + " was deleted. ";
        }
        logger.error("Address was not found");
        return "Address with id "+ id + " was not found. ";
    }

    public String updateAppointment(Address a){
        Long id = a.getId();

        if(repository.findById(id).isPresent()) {
            Address modifiedA = repository.findById(id).get();

            modifiedA.setStreet(a.getStreet());
            modifiedA.setNumber(a.getNumber());
            modifiedA.setLocality(a.getLocality());
            modifiedA.setProvince(a.getProvince());

            repository.save(modifiedA);
            logger.info("Address " + id +" was succesfully modified.");
            return "Address with Id: " + id + " was modified.";

        } else {
            logger.error("Address doesn't exist");
            return "Address with Id " + id + " does not exist.";
        }
    }
}

package com.dh.dentalClinic.service;
import com.dh.dentalClinic.persistence.entities.Address;
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

    public Address getById(long id) {
        if(repository.existsById(id)){
            Address address = repository.findById(id).get();
            logger.info("Looking for address with id:" + id);
            return address;
        }
        logger.info("Address was not found");
        return null;
    }
}

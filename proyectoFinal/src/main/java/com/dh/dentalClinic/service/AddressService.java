package com.dh.dentalClinic.service;


import com.dh.dentalClinic.persistence.entities.Address;
import com.dh.dentalClinic.persistence.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository repository;
    public String save(Address a){
        if (repository.save(a)!= null){
            return "OK";
        }else{
            return null;
        }
    }
    public List<Address> getAll(){
        return repository.findAll();
    }
}

package com.dh.clinica.service;


import com.dh.clinica.persistence.entities.Domicilio;
import com.dh.clinica.persistence.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DomicilioService {
    @Autowired
    DomicilioRepository repository;
    public String save(Domicilio d){
        if (repository.save(d)!= null){
            return "OK";
        }else{
            return null;
        }
    }
    public List<Domicilio> obtenerTodos(){
        return repository.findAll();
    }
}

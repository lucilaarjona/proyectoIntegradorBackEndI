package com.dh.clinica.service;

import com.dh.clinica.persistence.entities.Odontologo;
import com.dh.clinica.persistence.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OdontologoService {
    @Autowired
    OdontologoRepository repository;

    public String save(Odontologo o){
        if (repository.save(o)!= null){
            return "Ok";
        }else {
            return null;
        }
    }
    public List<Odontologo> obtenerTodos(){
        return repository.findAll();
    }

}

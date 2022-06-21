package com.dh.clinica.service;

import com.dh.clinica.persistence.entities.Turno;
import com.dh.clinica.persistence.repository.TurnosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    @Autowired
    TurnosRepository repository;
    public String save (Turno t){
        if (repository.save(t)!=null){
            return "Ok";
        }else{
            return null;
        }
    }
    public List<Turno> obtenerTodos(){
        return repository.findAll();
    }
}

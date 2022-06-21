package com.dh.clinica.service;


import com.dh.clinica.persistence.entities.Paciente;
import com.dh.clinica.persistence.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;
    public String save (Paciente p){
        if (repository.save(p)!= null){
            return "OK";
        }else {
            return null;
        }
    }
    public List<Paciente> obtenerTodos() {
        return repository.findAll();
    }
}

package com.example.proyectoFinal.services;

import com.example.proyectoFinal.dao.IDao;
import com.example.proyectoFinal.models.Paciente;

import java.util.List;

public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardar(Paciente p) {
        return pacienteIDao.guardar(p);
    }

    public Paciente buscar(Long id) {
        return pacienteIDao.buscar(id);
    }

    public List<Paciente> buscarTodos() {
        return pacienteIDao.buscarTodos();
    }

    public void eliminar(Long id) {
        pacienteIDao.eliminar(id);
    }
}
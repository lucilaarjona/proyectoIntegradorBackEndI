package com.example.proyectoFinal.services;

import com.example.proyectoFinal.dao.IDao;
import com.example.proyectoFinal.models.Odontologo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OdontologoService {
    private List<Odontologo> odontologoList = new ArrayList<>();
    private IDao<Odontologo> odontologoIdao;

    public OdontologoService(IDao<Odontologo> odontologoIdao) {
        this.odontologoIdao = odontologoIdao;
    }

    public OdontologoService() {
        odontologoList.add(new Odontologo(1L, "Juan", "Lopez", "654"));
    }
    public List<Odontologo> getAll(){
        return odontologoList;
    }
    public Odontologo guardar(Odontologo odontologo){
        odontologoList.add(odontologo);
        return odontologo;
    }
    public Odontologo getOdontologoById(long id) {
        return odontologoList.stream().filter(x -> x.getId() == (id)).findFirst().orElse(null);
    }
    public List<Odontologo> buscarTodos(){
        return this.odontologoIdao.buscarTodos();
    }
}
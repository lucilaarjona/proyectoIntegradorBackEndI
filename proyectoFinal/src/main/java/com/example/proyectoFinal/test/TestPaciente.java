package com.example.proyectoFinal.test;

import com.example.proyectoFinal.dao.impl.OdontologoDaoH2;
import com.example.proyectoFinal.models.Odontologo;
import com.example.proyectoFinal.services.OdontologoService;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)

public class TestPaciente {
    private static OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @BeforeClass
    public static void cargarDataSet() {
        Odontologo odontologo = odontologoService.guardar(new Odontologo("13141516","Federico", "Ponce"));
        Odontologo odontologo1 = odontologoService.guardar(new Odontologo("17181920","Matilda", "Cáceres"));
    }

    @Test
    public void traerTodos() {
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        System.out.println(odontologos);
    }
}

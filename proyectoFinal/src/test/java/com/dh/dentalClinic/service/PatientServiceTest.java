package com.dh.dentalClinic.service;

import com.dh.dentalClinic.persistence.entities.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PatientServiceTest {
    @Autowired
    private PatientService patienteService;

    @Test
    public void crearPaciente(){

        Patient patient = new Patient();


        patient.setFirstName("Adrian");
        patient.setLastName("Acosta");
        patient.setDni("45588896");
        patient.setAdmissionDate(new Date(2022-06-06));
//        patient.setDentist(new Dentist());
//        patient.setAddress(new Address());
        patienteService.save(patient);

        Patient patient1 = patienteService.getById(1L);
        System.out.println(patient);

        assertTrue(patient != null);
    }

}
package com.dh.dentalClinic.service;

import com.dh.dentalClinic.persistence.entities.Dentist;
import com.dh.dentalClinic.persistence.entities.Patient;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PatientServiceTest {
    @Autowired
    PatientService patientService;

    @Order(1)
    @Test
    public void testCreate(){
        Patient patient = new Patient();
        patient.setFirstName("Lucila");
        patientService.save(patient);
        Patient patient1 = patientService.getById(1L);
        assertTrue(patient1 != null);
    }

    @Order(2)
    @Test
    public void testReadAll () {
        List list = patientService.getAll();
        assertTrue(list.size() == 1);
    }

    @Order(3)
    @Test
    public void testUpdate () {
        Patient dUpdated = patientService.getById(1L);
        dUpdated.setLastName("Moncada");
        patientService.updatePatient(dUpdated);

        assertTrue(patientService.getById(1L).getFirstName() == "Lucila");
        assertTrue(patientService.getById(1L).getLastName() == "Moncada");
    }

    @Order(4)
    @Test
    public void testDelete () {
        patientService.delete(patientService.getById(1L).getId());
        assertTrue(patientService.getById(1L) == null);
    }

}
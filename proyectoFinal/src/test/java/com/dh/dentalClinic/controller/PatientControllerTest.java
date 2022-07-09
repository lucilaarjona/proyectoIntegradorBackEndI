package com.dh.dentalClinic.controller;

import com.dh.dentalClinic.dentalClinicAPI.controller.PatientController;
import com.dh.dentalClinic.dentalClinicAPI.persistence.entities.Patient;
import com.dh.dentalClinic.exceptions.BadRequestException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PatientControllerTest {

    @Autowired
    PatientController patientController;

    String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwiaWF0IjoxNjU3MTQ5MzY4LCJzdWIiOiJwZXBhQG1haWwuY29tIiwiaXNzIjoiTWFpbiIsImV4cCI6MTY1Nzc1NDE2OH0.ylKmw9AtwqNjZxwJvpgjxAIHf48bfhPm7Hh4V5DClJY";

    @Order(1)
    @Test
    public void testCreate() throws BadRequestException {
        Patient patient = new Patient();
        patient.setFirstName("Lucila");
        patientController.create(token, patient);
        assertNotNull(patientController.getById(token,1L));
    }

    @Order(2)
    @Test
    public void testReadAll () throws BadRequestException{
        assertTrue(patientController.getAll(token).size() == 1);
    }

    @Order(3)
    @Test
    public void testUpdate () throws BadRequestException {
        Patient pUpdated = patientController.getById(token,1L);
        pUpdated.setLastName("Moncada");
        patientController.update(token, pUpdated);
        assertTrue(patientController.getById(token,1L).getLastName() == "Moncada");
    }

    @Order(4)
    @Test
    public void testReadById () throws BadRequestException{
        assertTrue(patientController.getById(token, 1L).getId() != null);
    }

    @Order(5)
    @Test
    public void testDelete () throws BadRequestException{
        patientController.delete(token, 1L);
        assertEquals(BadRequestException.class, BadRequestException.class);
    }
}

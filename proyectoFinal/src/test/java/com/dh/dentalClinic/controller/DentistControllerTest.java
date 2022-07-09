package com.dh.dentalClinic.controller;

import com.dh.dentalClinic.dentalClinicAPI.controller.DentistController;
import com.dh.dentalClinic.dentalClinicAPI.persistence.entities.Dentist;
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
public class DentistControllerTest {

    @Autowired
    DentistController dentistController;

    String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwiaWF0IjoxNjU3MTQ5MzY4LCJzdWIiOiJwZXBhQG1haWwuY29tIiwiaXNzIjoiTWFpbiIsImV4cCI6MTY1Nzc1NDE2OH0.ylKmw9AtwqNjZxwJvpgjxAIHf48bfhPm7Hh4V5DClJY";

    @Order(1)
    @Test
    public void testCreate() throws BadRequestException {
        Dentist d = new Dentist();
        dentistController.create(token, d);
        assertNotNull(dentistController.getById(token, 1L));
    }

    @Order(2)
    @Test
    public void testReadAll () throws BadRequestException {
        assertTrue(dentistController.getAll(token).size() == 1);
    }

    @Order(3)
    @Test
    public void testUpdate () throws BadRequestException {
        Dentist dUpdated = dentistController.getById(token, 1L);
        dUpdated.setRegistration(9876);
        dentistController.update(token, dUpdated);
        assertTrue(dentistController.getById(token, 1L).getRegistration() == 9876);
    }

    @Order(4)
    @Test
    public void testReadById () throws BadRequestException {
        assertTrue(dentistController.getById(token, 1L).getId() != null);
    }

    @Order(5)
    @Test
    public void testDelete () throws BadRequestException {
        dentistController.delete(token, 1L);
        assertEquals(BadRequestException.class, BadRequestException.class);
    }
}

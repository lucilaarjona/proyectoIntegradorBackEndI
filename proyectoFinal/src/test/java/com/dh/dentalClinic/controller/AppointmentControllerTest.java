package com.dh.dentalClinic.controller;

import com.dh.dentalClinic.dentalClinicAPI.controller.AppointmentController;
import com.dh.dentalClinic.dentalClinicAPI.persistence.entities.Appointment;
import com.dh.dentalClinic.exceptions.BadRequestException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppointmentControllerTest {

    @Autowired
    AppointmentController appointmentController;

    String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwiaWF0IjoxNjU3MTQ5MzY4LCJzdWIiOiJwZXBhQG1haWwuY29tIiwiaXNzIjoiTWFpbiIsImV4cCI6MTY1Nzc1NDE2OH0.ylKmw9AtwqNjZxwJvpgjxAIHf48bfhPm7Hh4V5DClJY";

    @Order(1)
    @Test
    public void testCreate() throws BadRequestException {
        appointmentController.create(token, new Appointment());
        assertTrue(appointmentController.getById(token,1L) != null);
    }

    @Order(2)
    @Test
    public void testReadAll () throws BadRequestException{
        assertTrue(appointmentController.getAll(token).size() == 1);
    }

    @Order(3)
    @Test
    public void testUpdate () throws BadRequestException {
        Appointment dUpdated = appointmentController.getById(token,1L);
        dUpdated.setDate(new Date(2000-02-02));
        appointmentController.update(token, dUpdated);
        assertTrue(appointmentController.getById(token,1L).getDate() != null);
    }

    @Order(4)
    @Test
    public void testReadById () throws BadRequestException{
        assertTrue(appointmentController.getById(token,1L).getId() != null);
    }

    @Order(5)
    @Test
    public void testDelete () throws BadRequestException{
        appointmentController.delete(token, appointmentController.getById(token,1L).getId());
        assertEquals(BadRequestException.class, BadRequestException.class);
    }
}

package com.dh.dentalClinic.service;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.dentalClinicAPI.persistence.entities.Appointment;
import com.dh.dentalClinic.dentalClinicAPI.service.AppointmentService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppointmentServiceTest {

    @Autowired
    AppointmentService appointmentService;

    @Order(1)
    @Test
    public void testCreate() throws BadRequestException{
        appointmentService.save(new Appointment());
        assertTrue(appointmentService.getById(1L) != null);
    }

    @Order(2)
    @Test
    public void testReadAll () throws BadRequestException{
        assertTrue(appointmentService.getAll().size() == 1);
    }

    @Order(3)
    @Test
    public void testUpdate () throws BadRequestException {
        Appointment dUpdated = appointmentService.getById(1L);
        dUpdated.setDate(new Date(2000-02-02));
        appointmentService.updateAppointment(dUpdated);
        assertTrue(appointmentService.getById(1L).getDate() != null);
    }

    @Order(4)
    @Test
    public void testReadById () throws BadRequestException{
        assertTrue(appointmentService.getById(1L).getId() != null);
    }

    @Order(5)
    @Test
    public void testDelete () throws BadRequestException{
        appointmentService.delete(appointmentService.getById(1L).getId());
        assertEquals(BadRequestException.class, BadRequestException.class);
    }
}
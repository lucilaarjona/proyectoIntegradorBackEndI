package com.dh.dentalClinic.service;
import com.dh.dentalClinic.persistence.entities.Appointment;
import com.dh.dentalClinic.persistence.entities.Dentist;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
    public void testCreate(){
        appointmentService.save(new Appointment());
        assertTrue(appointmentService.getById(1L) != null);
    }

    @Order(2)
    @Test
    public void testReadAll () {
        assertTrue(appointmentService.getAll().size() == 1);
    }

    @Order(3)
    @Test
    public void testUpdate () {
        Appointment dUpdated = appointmentService.getById(1L);
        dUpdated.setDate(new Date(2000-02-02));
        appointmentService.updateAppointment(dUpdated);
        Date date = dUpdated.getDate();
        System.out.println(appointmentService.getById(1L).getDate());
        assertTrue(appointmentService.getById(1L).getDate() != null);
    }

    @Order(4)
    @Test
    public void testReadById () {
        Appointment a = new Appointment();
        a.setId(1L);
        appointmentService.save(a);
        Appointment app = appointmentService.getById(1L);
        assertTrue(app.getId() != null);
    }

    @Order(5)
    @Test
    public void testDelete () {
        appointmentService.delete(appointmentService.getById(1L).getId());
        assertTrue(appointmentService.getById(1L) == null);
    }

}
package com.dh.dentalClinic.service;

import com.dh.dentalClinic.persistence.entities.Appointment;
import com.dh.dentalClinic.persistence.entities.Dentist;
import com.dh.dentalClinic.persistence.entities.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AppointmentServiceTest {
    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void crearAppointment(){
<<<<<<< HEAD

=======
>>>>>>> 47e2b1fd7ee4c7b9ff1cb09dcf27d3bf0233772a
        Appointment appointment = new Appointment();
        appointment.setDate(new Date(2022-12-02));
        appointmentService.save(appointment);
        Appointment appointment1 = appointmentService.getById(1L);
        assertTrue(appointment1 != null);
    }

}
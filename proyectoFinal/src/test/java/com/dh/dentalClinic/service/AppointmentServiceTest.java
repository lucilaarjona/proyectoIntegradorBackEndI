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

        Appointment appointment = new Appointment();

//        appointment.setPatient(new Patient());
//        appointment.setDentist(new Dentist());
        appointment.setDate(new Date(2022-12-02));

        appointmentService.save(appointment);
        Appointment appointment1 = appointmentService.getById(1L);

=======
        Appointment appointment = new Appointment();
        appointment.setDate(new Date(2022-12-02));
        appointmentService.save(appointment);
        Appointment appointment1 = appointmentService.getById(1L);
>>>>>>> e965fd8b79ac1c9c826b8383b18ca64d51100f79
        assertTrue(appointment1 != null);
    }

}
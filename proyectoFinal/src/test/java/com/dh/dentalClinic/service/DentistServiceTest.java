package com.dh.dentalClinic.service;

import com.dh.dentalClinic.persistence.entities.Dentist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DentistServiceTest {
    @Autowired
    private DentistService dentistService;
    @Test
    public  void crearDentista(){
        Dentist dentist = new Dentist();
        dentist.setFirstName("Tomas");
        dentist.setLastName("Suarez");
        dentist.setRegistration(789);
        dentistService.save(dentist);
        Dentist dentist1 = dentistService.getById(1L);
        assertTrue(dentist1 != null);
    }

}
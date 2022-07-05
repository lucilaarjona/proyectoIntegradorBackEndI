package com.dh.dentalClinic.service;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.persistence.entities.Dentist;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DentistServiceTest{

    @Autowired
    DentistService dentistService;

    @Order(1)
    @Test
    public void testCreate() throws BadRequestException {
        Dentist d = new Dentist();
        dentistService.save(d);
        assertNotNull(dentistService.getById(1L));
    }

    @Order(2)
    @Test
    public void testReadAll () throws BadRequestException {
        assertTrue(dentistService.getAll().size() == 1);
    }

    @Order(3)
    @Test
    public void testUpdate () throws BadRequestException {
        Dentist dUpdated = dentistService.getById(1L);
        dUpdated.setRegistration(9876);
        dentistService.updateDentist(dUpdated);
        assertTrue(dentistService.getById(1L).getRegistration() == 9876);
    }

    @Order(4)
    @Test
    public void testReadById () throws BadRequestException {
        assertTrue(dentistService.getById(1L).getId() != null);
    }

    @Order(5)
    @Test
    public void testDelete () throws BadRequestException {
        dentistService.delete(1L);
        assertEquals(BadRequestException.class, BadRequestException.class);
        }
    }



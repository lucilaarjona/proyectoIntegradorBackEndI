package com.dh.dentalClinic.service;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.persistence.entities.Patient;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PatientServiceTest {
    @Autowired
    PatientService patientService;

    @Order(1)
    @Test
    public void testCreate() throws BadRequestException {
        Patient patient = new Patient();
        patient.setFirstName("Lucila");
        patientService.save(patient);
        assertNotNull(patientService.getById(1L));
    }

    @Order(2)
    @Test
    public void testReadAll () throws BadRequestException{
        assertTrue(patientService.getAll().size() == 1);
    }

    @Order(3)
    @Test
    public void testUpdate () throws BadRequestException {
        Patient pUpdated = patientService.getById(1L);
        pUpdated.setLastName("Moncada");
        patientService.updatePatient(pUpdated);
        assertTrue(patientService.getById(1L).getLastName() == "Moncada");
    }

    @Order(4)
    @Test
    public void testReadById () throws BadRequestException{
        assertTrue(patientService.getById(1L).getId() != null);
    }

    @Order(5)
    @Test
    public void testDelete () throws BadRequestException{
        patientService.delete(1L);
        assertEquals(BadRequestException.class, BadRequestException.class);
    }

}
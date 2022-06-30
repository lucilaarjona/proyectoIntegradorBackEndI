package com.dh.dentalClinic.service;

import com.dh.dentalClinic.persistence.entities.Address;
import com.dh.dentalClinic.persistence.entities.Dentist;
import com.dh.dentalClinic.persistence.entities.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DentistServiceTest{
    @Autowired
    DentistService dentistService;
    @Test
    public void testCreate(){
        Dentist d = new Dentist();
        d.setId(1L);
        dentistService.save(d);
        assertNotNull(dentistService.getById(1L));
    }

    @Test
    public void testReadAll () {
        Dentist d = new Dentist();
        d.setId(1L);
        dentistService.save(d);
        List list = dentistService.getAll();
        assertTrue(list.size() == 1);
    }
    @Test
    public void testDelete (){

        Dentist d = new Dentist();
        d.setId(1L);
        dentistService.save(d);
        dentistService.delete(1L);
        assertTrue(dentistService.getById(1L)==null);
    }
//    @Test
//    public void testUpdate () {
//        Dentist d = new Dentist();
//        d.setId(1L);
//        d.setFirstName("Isabela");
//        dentistService.save(d);
//        Dentist dUpdated = new Dentist();
//        dUpdated.setId(1L);
//        dUpdated.setFirstName("Lucila");
//        dentistService.updateDentist(dUpdated);
//        assertTrue(dentistService.getById(1L).getFirstName() == "Lucila");
//    }
    @Test
    public void testUpdate () {
        Dentist d = new Dentist();
        d.setId(1L); d.setFirstName("Adrián");
        dentistService.save(d);
        Dentist dJSON = new Dentist();
        dJSON.setId(1L);
        dJSON.setFirstName("Lucila");
        dJSON.setLastName("Arjona");
        dJSON.setRegistration(11221);
        Set<Patient> patients = new HashSet<>();
        Patient patient2 = new Patient();
        patients.add(patient2);
        dJSON.setPatients(patients);
        dentistService.getById(1L);
        dentistService.updateDentist(dJSON);
        assertTrue(dentistService.getById(1L).getFirstName()=="Lucila");
    }
}


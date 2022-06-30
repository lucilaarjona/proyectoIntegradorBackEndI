package com.dh.dentalClinic.service;

import com.dh.dentalClinic.persistence.entities.Address;

import com.dh.dentalClinic.persistence.entities.Dentist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

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

  @Test
    public void testUpdate () {
        Dentist d = new Dentist("Lucila", "Moncada",12345);
        d.setId(1L);

        dentistService.save(d);
        Dentist dUpdated = d;
        dUpdated.setId(1L);
        dUpdated.setRegistration(9876);
        dentistService.updateDentist(dUpdated);

        assertTrue(dentistService.getById(1L).getFirstName() == "Lucila");
    }
}
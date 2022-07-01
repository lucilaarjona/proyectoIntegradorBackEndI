package com.dh.dentalClinic.service;
import com.dh.dentalClinic.persistence.entities.Dentist;
import com.dh.dentalClinic.persistence.entities.Patient;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DentistServiceTest{
    @Autowired
    DentistService dentistService;

    @Order(3)
    @Test
    public void testCreate(){
        Dentist d = new Dentist();
        /*d.setId(1L);*/
        dentistService.save(d);
        assertNotNull(dentistService.getById(1L));
    }

    @Order(2)
    @Test
    public void testReadAll () {
        Dentist d = new Dentist();
        d.setId(1L);
        dentistService.save(d);
        List list = dentistService.getAll();
        assertTrue(list.size() == 1);
    }

        @Order(4)
        @Test
        public void testDelete () {
            Dentist d = new Dentist();
            /*d.setId(1L);*/
            dentistService.save(d);
            dentistService.delete(1L);
            assertTrue(dentistService.getById(1L) == null);
        }

        @Order(1)
        @Test
        public void testUpdate () {
            Dentist d = new Dentist("Lucila", "Moncada", 12345);
            d.setId(1L);


            Dentist dUpdated = d;
            /*dUpdated.setId(1L);*/
            dUpdated.setRegistration(9876);
            dentistService.save(d);
            dentistService.updateDentist(dUpdated);

            assertTrue(dentistService.getById(1L).getFirstName() == "Lucila");
            assertTrue(dentistService.getById(1L).getRegistration() == 9876);
        }
    }



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

    /*ARROJA EXCEPCIÓN*/
/*    @Test
    public void testDelete (){
        Dentist d = new Dentist();
        d.setId(2L);
        dentistService.save(d);
        System.out.println(dentistService.getById(2L));
        dentistService.delete(2L);
    }*/

/*    @Test
    public void testUpdate () {
        Dentist d = new Dentist();
        d.setId(1L);
        d.setFirstName("Isabela");
        dentistService.save(d);
        Dentist dUpdated = new Dentist();
        dUpdated.setId(1L);
        dUpdated.setFirstName("Lucila");
        dentistService.updateDentist(dUpdated);

        assertTrue(dentistService.getById(1L).getFirstName() == "Lucila");
    }*/

}
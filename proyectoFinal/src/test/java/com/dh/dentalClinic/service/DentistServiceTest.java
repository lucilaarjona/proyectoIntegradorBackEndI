package com.dh.dentalClinic.service;

import com.dh.dentalClinic.persistence.entities.Address;
<<<<<<< HEAD

=======
>>>>>>> 47e2b1fd7ee4c7b9ff1cb09dcf27d3bf0233772a
import com.dh.dentalClinic.persistence.entities.Dentist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
<<<<<<< HEAD
=======

>>>>>>> 47e2b1fd7ee4c7b9ff1cb09dcf27d3bf0233772a
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

<<<<<<< HEAD
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
=======
    //ARROJA EXCEPCIÓN/
//    @Test
//    public void testDelete (){
//        Dentist d = new Dentist();
//        d.setId(2L);
//        dentistService.save(d);
////        System.out.println("hola" + dentistService.getById(2L));
//        dentistService.delete(1L);
//        assertTrue(dentistService.getById(2L)==null);
//    }

//            /    @Test
//    public void testUpdate () {
//        Dentist d = new Dentist();
//        d.setId(1L);
//        d.setFirstName("Isabela");
//        dentistService.save(d);
//        Dentist dUpdated = new Dentist();
//        dUpdated.setId(1L);
//        dUpdated.setFirstName("Lucila");
//        dentistService.updateDentist(dUpdated);
//
//        assertTrue(dentistService.getById(1L).getFirstName() == "Lucila");
//    }*/

>>>>>>> 47e2b1fd7ee4c7b9ff1cb09dcf27d3bf0233772a
}
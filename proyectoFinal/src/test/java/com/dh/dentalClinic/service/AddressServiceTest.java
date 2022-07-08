package com.dh.dentalClinic.service;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.persistence.entities.Address;
import com.dh.dentalClinic.persistence.entities.Appointment;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressServiceTest {
    @Autowired
    AddressService addressService;
    @Order(1)
    @Test
    public void testCreate() throws BadRequestException {
        Address address = new Address();
        addressService.save(address);
        assertTrue(addressService.getById(1L) != null);
    }

    @Order(2)
    @Test
    public void testReadAll () throws BadRequestException {
        assertTrue(addressService.getAll().size() == 1);
    }

    @Order(3)
    @Test
    public void testUpdate () throws BadRequestException {
        Address aUpdated = addressService.getById(1L);
        aUpdated.setNumber("123");
        addressService.updateAppointment(aUpdated);
        assertTrue(addressService.getById(1L).getNumber() != null);
    }

    @Order(4)
    @Test
    public void testReadById () throws BadRequestException{
        assertTrue(addressService.getById(1L).getId() != null);
    }

    @Order(5)
    @Test
    public void testDelete () throws BadRequestException{
        addressService.delete(addressService.getById(1L).getId());
        assertEquals(BadRequestException.class, BadRequestException.class);
    }

}
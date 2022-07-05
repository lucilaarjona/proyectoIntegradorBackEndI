package com.dh.dentalClinic.service;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.persistence.entities.Address;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
package com.dh.dentalClinic.controller;

import com.dh.dentalClinic.dentalClinicAPI.controller.AddressController;
import com.dh.dentalClinic.dentalClinicAPI.persistence.entities.Address;
import com.dh.dentalClinic.exceptions.BadRequestException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddressControllerTest {

    @Autowired
    AddressController addressController;

    String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwiaWF0IjoxNjU3MTQ5MzY4LCJzdWIiOiJwZXBhQG1haWwuY29tIiwiaXNzIjoiTWFpbiIsImV4cCI6MTY1Nzc1NDE2OH0.ylKmw9AtwqNjZxwJvpgjxAIHf48bfhPm7Hh4V5DClJY";

    @Order(1)
    @Test
    public void testCreate() throws BadRequestException {
        Address address = new Address();
        addressController.create(token, address);
        assertTrue(addressController.getById(token,1L) != null);
    }

    @Order(2)
    @Test
    public void testReadAll () throws BadRequestException {
        assertTrue(addressController.getAll(token).size() == 1);
    }

    @Order(3)
    @Test
    public void testUpdate () throws BadRequestException {
        Address aUpdated = addressController.getById(token,1L);
        aUpdated.setNumber("123");
        addressController.update(token, aUpdated);
        assertTrue(addressController.getById(token,1L).getNumber() != null);
    }

    @Order(4)
    @Test
    public void testReadById () throws BadRequestException{
        assertTrue(addressController.getById(token,1L).getId() != null);
    }

    @Order(5)
    @Test
    public void testDelete () throws BadRequestException{
        addressController.delete(token, addressController.getById(token,1L).getId());
        assertEquals(BadRequestException.class, BadRequestException.class);
    }
}

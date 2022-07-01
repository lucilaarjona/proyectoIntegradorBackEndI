package com.dh.dentalClinic.service;


import com.dh.dentalClinic.persistence.entities.Address;
import com.dh.dentalClinic.persistence.entities.Patient;
import com.dh.dentalClinic.persistence.repository.AddressRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AddressServiceTest {
    @Autowired

    AddressService addressService;
    @Order(1)
    @Test
    public void testCreate(){
        Address address = new Address();
        address.setStreet("San Martin");
        address.setProvince("Santa Fe");
        address.setNumber("123");
        address.setLocality("Las Heras");
        addressService.save(address);
        Address address1 = addressService.getById(1L);
        assertTrue(address1 != null);
    }

    @Order(2)
    @Test
    public void testReadAll () {
        List list = addressService.getAll();
        assertTrue(list.size() != 1);
    }

}
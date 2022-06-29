package com.dh.dentalClinic.service;

import com.dh.dentalClinic.persistence.entities.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AddressServiceTest {
    @Autowired
    private AddressService addressService;
    @Test
    public  void crearDireccion(){
        Address address = new Address();
        address.setLocality("Santa fe");
        address.setNumber("46578");
        address.setStreet("San Martin");
        address.setProvince("San Juan");
        addressService.save(address);
        Address address1 = addressService.getById(1L);
        assertTrue(address1 != null);
    }

}
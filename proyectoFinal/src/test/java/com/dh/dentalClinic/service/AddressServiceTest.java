package com.dh.dentalClinic.service;

import com.dh.dentalClinic.persistence.entities.Address;
import com.dh.dentalClinic.persistence.repository.AddressRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
<<<<<<< HEAD

=======
>>>>>>> 47e2b1fd7ee4c7b9ff1cb09dcf27d3bf0233772a
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

<<<<<<< HEAD

=======
>>>>>>> 47e2b1fd7ee4c7b9ff1cb09dcf27d3bf0233772a
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AddressServiceTest {
    @Autowired
<<<<<<< HEAD

=======
>>>>>>> 47e2b1fd7ee4c7b9ff1cb09dcf27d3bf0233772a
    AddressService addressService;

    @Test
    public void testCreate () {
        Address a = new Address();
        a.setId(1L);
        addressService.save(a);
        assertNotNull(addressService.getById(1L));
    }

    @Test
    public void testReadAll () {
        Address a = new Address();
        a.setId(1L);
        addressService.save(a);
        List list = addressService.getAll();
        assertTrue(list.size() == 1);
    }
}
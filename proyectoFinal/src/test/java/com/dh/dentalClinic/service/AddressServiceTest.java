package com.dh.dentalClinic.service;

import com.dh.dentalClinic.persistence.entities.Address;
<<<<<<< HEAD
=======
import com.dh.dentalClinic.persistence.repository.AddressRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
>>>>>>> e965fd8b79ac1c9c826b8383b18ca64d51100f79
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> e965fd8b79ac1c9c826b8383b18ca64d51100f79
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AddressServiceTest {
    @Autowired
<<<<<<< HEAD
    private AddressService addressService;
    @Test
    public  void crearDireccion(){
        Address address = new Address();
        address.setLocality("Santa fe");
        address.setNumber("46578");
        address.setStreet("San Martin");
        address.setProvince("San Juan");
        addressService.save(address);
        Address address1 = addressService.getById (1L);
        assertTrue(address1 != null);
    }

=======
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
>>>>>>> e965fd8b79ac1c9c826b8383b18ca64d51100f79
}
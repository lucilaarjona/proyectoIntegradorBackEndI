package com.dh.dentalClinic.controller;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.persistence.entities.Address;
import com.dh.dentalClinic.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {


    @Autowired
    AddressService service;

    @PostMapping
    public Address create(@RequestBody Address a) throws BadRequestException {
        return service.save(a);
    }

    @GetMapping
    public List<Address> getAll() throws BadRequestException{
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable Long id) throws BadRequestException{
        return service.getById(id);
    }

    @DeleteMapping(value = "{id}")
    public String delete(@PathVariable Long id) throws BadRequestException{
        return service.delete(id);
    }

    @PutMapping
    public String update(@RequestBody Address a) throws BadRequestException{
        return service.updateAppointment(a);
    }

}

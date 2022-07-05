package com.dh.dentalClinic.controller;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.persistence.entities.Address;
import com.dh.dentalClinic.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {


    @Autowired
    AddressService service;

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody Address a) throws BadRequestException {
        ResponseEntity<String> response = null;

        if(service.save(a) != null) {
            response = ResponseEntity.ok("Address created.");
        } else {
            response = ResponseEntity.internalServerError().body("Oops");
        }
        return response;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
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

    @PutMapping("")
    public String update(@RequestBody Address a) throws BadRequestException{
        return service.updateAppointment(a);
    }

}

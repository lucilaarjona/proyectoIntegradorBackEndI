package com.dh.dentalClinic.controller;
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
    public ResponseEntity<String> create(@RequestBody Address a) {
        ResponseEntity<String> response = null;

        if(service.save(a) != null) {
            response = ResponseEntity.ok("Address created.");
        } else {
            response = ResponseEntity.internalServerError().body("Oops");
        }
        return response;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public List<Address> getAll() {
        return service.getAll();
    }

}

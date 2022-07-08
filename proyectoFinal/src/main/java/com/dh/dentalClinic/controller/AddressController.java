package com.dh.dentalClinic.controller;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.persistence.entities.Address;
import com.dh.dentalClinic.service.AddressService;
import com.dh.dentalClinic.user.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    AddressService service;

    @PostMapping
    public Address create(@RequestHeader(value = "Authorization") String token, @RequestBody Address a) throws BadRequestException {
        if (!jwtUtil.validateToken(token)) { return null; }
        return service.save(a);
    }

    @GetMapping
    public List<Address> getAll(@RequestHeader(value = "Authorization") String token) throws BadRequestException{
        if (!jwtUtil.validateToken(token)) { return null; }
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Address getById(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) throws BadRequestException{
        if (!jwtUtil.validateToken(token)) { return null; }
        return service.getById(id);
    }

    @DeleteMapping(value = "{id}")
    public String delete(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) throws BadRequestException{
        if (!jwtUtil.validateToken(token)) { return null; }
        return service.delete(id);
    }

    @PutMapping
    public String update(@RequestHeader(value = "Authorization") String token, @RequestBody Address a) throws BadRequestException{
        if (!jwtUtil.validateToken(token)) { return null; }
        return service.updateAppointment(a);
    }
}

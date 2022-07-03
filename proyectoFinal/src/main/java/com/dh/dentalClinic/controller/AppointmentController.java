package com.dh.dentalClinic.controller;
import com.dh.dentalClinic.persistence.entities.Appointment;
import com.dh.dentalClinic.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    AppointmentService service;

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody Appointment a) {
        ResponseEntity<String> response = null;

        if(service.save(a) != null) {
            response = ResponseEntity.ok("appointment created.");
        } else {
            response = ResponseEntity.internalServerError().body("Oops");
        }
        return response;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public List<Appointment> getAll() {
        return service.getAll();
    }


    @GetMapping("/{id}")
    public Appointment getById(@PathVariable Long id) {
        return service.getById(id);
    }


    @DeleteMapping(value = "{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("")
    public String update(@RequestBody Appointment a){
        return service.updateAppointment(a);
    }

}

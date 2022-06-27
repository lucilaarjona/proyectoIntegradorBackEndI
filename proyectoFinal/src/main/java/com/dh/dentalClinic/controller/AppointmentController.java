package com.dh.dentalClinic.controller;

import com.dh.dentalClinic.persistence.entities.Appointment;
import com.dh.dentalClinic.persistence.entities.Dentist;
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
    public ResponseEntity<String> createAppointment(@RequestBody Appointment app) {
        ResponseEntity<String> response = null;

        if(service.save(app) != null) {
            response = ResponseEntity.ok("appointment created.");
        } else {
            response = ResponseEntity.internalServerError().body("Oops");
        }
        return response;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public List<Appointment> getAllAppointments() {
        return service.getAll();
    }


    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return service.getById(id);
    }


    @DeleteMapping(value = "{id}")
    public String deleteAppointment(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("")
    public String updateAppointment(@RequestBody Appointment appointment){
        return service.updateAppointment(appointment);
    }
}

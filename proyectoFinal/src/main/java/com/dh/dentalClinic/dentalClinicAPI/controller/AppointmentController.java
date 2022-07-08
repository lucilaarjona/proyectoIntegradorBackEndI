package com.dh.dentalClinic.dentalClinicAPI.controller;
import com.dh.dentalClinic.dentalClinicAPI.service.AppointmentService;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.dentalClinicAPI.persistence.entities.Appointment;
import com.dh.dentalClinic.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    AppointmentService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestHeader(value = "Authorization") String token, @RequestBody Appointment a) throws BadRequestException {

        ResponseEntity<String> response = null;
        if (!jwtUtil.validateToken(token)) { return null; }
        if(service.save(a) != null) {
            response = ResponseEntity.ok("Appointment created");
        } else {
            response = ResponseEntity.internalServerError().body("Oops");
        }
        return response;
    }

    @GetMapping
    public List<Appointment> getAll(@RequestHeader(value = "Authorization") String token) throws BadRequestException{
        if (!jwtUtil.validateToken(token)) { return null; }
        return service.getAll();
    }


    @GetMapping("/{id}")
    public Appointment getById(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) throws BadRequestException{
        if (!jwtUtil.validateToken(token)) { return null; }
        return service.getById(id);
    }


    @DeleteMapping(value = "{id}")
    public String delete(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) throws BadRequestException{
        if (!jwtUtil.validateToken(token)) { return null; }
        return service.delete(id);
    }

    @PutMapping
    public String update(@RequestHeader(value = "Authorization") String token, @RequestBody Appointment a) throws BadRequestException{
        if (!jwtUtil.validateToken(token)) { return null; }
        return service.updateAppointment(a);
    }
}

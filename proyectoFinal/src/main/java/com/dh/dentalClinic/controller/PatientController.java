package com.dh.dentalClinic.controller;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.persistence.entities.Patient;
import com.dh.dentalClinic.service.PatientService;
import com.dh.dentalClinic.user.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    PatientService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestHeader(value = "Authorization") String token, @RequestBody Patient p) throws BadRequestException{
        if (!validateToken(token)) { return null; }
        ResponseEntity<String> response = null;

        if(service.save(p) != null) {
            response = ResponseEntity.ok("Patient created.");
        } else {
            response = ResponseEntity.internalServerError().body("Oops");
        }
        return response;
    }

    @GetMapping
    public List<Patient> getAll(@RequestHeader(value = "Authorization") String token) throws BadRequestException{
        if (!validateToken(token)) { return null; }
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Patient getById(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) throws BadRequestException {
        if (!validateToken(token)) { return null; }
        return service.getById(id);
    }

    @DeleteMapping(value = "{id}")
    public String delete(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) throws BadRequestException{
        if (!validateToken(token)) { return null; }
        return service.delete(id);
    }

    @PutMapping
    public String update(@RequestHeader(value = "Authorization") String token, @RequestBody Patient p) throws BadRequestException{
        if (!validateToken(token)) { return null; }
        return service.updatePatient(p);
    }

    private boolean validateToken(String token) {
        String userId = jwtUtil.getKey(token);
        return userId != null;
    }

}

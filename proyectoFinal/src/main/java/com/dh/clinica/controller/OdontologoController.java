package com.dh.clinica.controller;
import com.dh.clinica.persistence.entities.Odontologo;
import com.dh.clinica.service.OdontologoService;
import com.dh.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    OdontologoService service;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Odontologo d) {
        ResponseEntity<String> response = null;

        if(service.save(d) != null) {
            response = ResponseEntity.ok("Dentist created.");
        } else {
            response = ResponseEntity.internalServerError().body("Oops");
        }
        return response;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<Odontologo> getProduct() {
        return service.obtenerTodos();
    }
}

package com.dh.clinica.controller;

import com.dh.clinica.persistence.entities.Paciente;
import com.dh.clinica.persistence.entities.Turno;
import com.dh.clinica.service.OdontologoService;
import com.dh.clinica.service.PacienteService;
import com.dh.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    TurnoService service;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Turno t) {
        ResponseEntity<String> response = null;

        if(service.save(t) != null) {
            response = ResponseEntity.ok("appointment created.");
        } else {
            response = ResponseEntity.internalServerError().body("Oops");
        }
        return response;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<Turno> getProduct() {
        return service.obtenerTodos();
    }
}

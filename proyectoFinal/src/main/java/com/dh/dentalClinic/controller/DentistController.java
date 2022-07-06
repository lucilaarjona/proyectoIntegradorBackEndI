package com.dh.dentalClinic.controller;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.persistence.entities.Dentist;
import com.dh.dentalClinic.service.DentistService;
import com.dh.dentalClinic.user.controllers.UsuarioController;
import com.dh.dentalClinic.user.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dentists")
public class DentistController {
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    DentistService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Dentist d) throws BadRequestException {
        ResponseEntity<String> response = null;

        if(service.save(d) != null) {
            response = ResponseEntity.ok("Dentist created.");
        } else {
            response = ResponseEntity.internalServerError().body("Oops");
        }
        return response;
    }

    @GetMapping()
    public List<Dentist> getAll() throws BadRequestException {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Dentist getById(@PathVariable Long id) throws BadRequestException {
        return service.getById(id);
    }
    
    @DeleteMapping(value = "{id}")
    public String delete(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) throws BadRequestException {
         if (!validarToken(token)) { return null; }
         return service.delete(id);
    }
    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }


    @PutMapping
    public String update(@RequestBody Dentist d) throws BadRequestException {
        return service.updateDentist(d);
    }

}

package com.dh.dentalClinic.userAPI.controllers;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.userAPI.persistance.entities.User;
import com.dh.dentalClinic.userAPI.service.UserService;
import com.dh.dentalClinic.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> getAll(@RequestHeader(value="Authorization") String token) throws BadRequestException {
        if (!jwtUtil.validateToken(token)) { return null; }

        return userService.getAll();
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void create(@RequestBody User user) throws BadRequestException {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);

        userService.save(user);
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void delete(@RequestHeader(value="Authorization") String token,
                       @PathVariable Long id) throws BadRequestException {
        if (!jwtUtil.validateToken(token)) { return; }
        userService.delete(id);
    }

}

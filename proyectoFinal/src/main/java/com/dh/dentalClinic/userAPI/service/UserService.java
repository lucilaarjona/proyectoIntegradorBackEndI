package com.dh.dentalClinic.userAPI.service;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.exceptions.GlobalExceptions;
import com.dh.dentalClinic.userAPI.persistance.entities.User;
import com.dh.dentalClinic.userAPI.persistance.repository.UserRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService extends GlobalExceptions {

    @Autowired
    UserRepository repository;

    public List<User> getAll() throws BadRequestException {
        if (repository.findAll().size()== 0) {
            throw new BadRequestException("There aren't any users created yet.");
        }
        return repository.findAll();
    }

    public String delete(Long id) throws BadRequestException{
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            return "User with id: "+ id + " was deleted. ";
        }
        throw new BadRequestException("User with id: " + id + " was not found.");
    }

    public User save(User a) throws BadRequestException {
        return repository.save(a);
    }

    public User obtainByCredentials(User user) {
        User userObtained = repository.getByemail(user.getEmail());
        System.out.println("The user is: " + repository.getByemail(user.getEmail()));

        if (userObtained == null) {
            System.out.println("is null.");
            return null;
        }
        System.out.println("is NOT NULL. hashing...");
        String passwordHashed = userObtained.getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, user.getPassword())) {
            return userObtained;
        }
        return null;
    }
}

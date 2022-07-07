package com.dh.dentalClinic.user.dao;
import com.dh.dentalClinic.user.models.User;
import java.util.List;

public interface UserDao {

    List<User> getAll();

    void delete(Long id);

    void save(User user);

    User obtainByCredentials(User user);
}

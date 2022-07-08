package com.dh.dentalClinic.userAPI.persistance.repository;

import com.dh.dentalClinic.userAPI.persistance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User getByemail(String email);
}

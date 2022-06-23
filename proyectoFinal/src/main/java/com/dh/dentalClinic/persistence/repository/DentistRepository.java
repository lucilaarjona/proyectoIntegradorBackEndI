package com.dh.dentalClinic.persistence.repository;

import com.dh.dentalClinic.persistence.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Long> {

}

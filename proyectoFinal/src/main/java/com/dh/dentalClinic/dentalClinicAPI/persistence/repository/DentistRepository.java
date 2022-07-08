package com.dh.dentalClinic.dentalClinicAPI.persistence.repository;

import com.dh.dentalClinic.dentalClinicAPI.persistence.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {

}

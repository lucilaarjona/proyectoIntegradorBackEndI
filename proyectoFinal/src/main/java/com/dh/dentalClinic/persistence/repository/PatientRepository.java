package com.dh.dentalClinic.persistence.repository;

import com.dh.dentalClinic.persistence.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

package com.dh.dentalClinic.persistence.repository;

import com.dh.dentalClinic.persistence.entities.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, Long> {
}

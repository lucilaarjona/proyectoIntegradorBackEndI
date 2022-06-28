package com.dh.dentalClinic.persistence.repository;

import com.dh.dentalClinic.persistence.entities.Dentist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends MongoRepository<Dentist, Long> {

}

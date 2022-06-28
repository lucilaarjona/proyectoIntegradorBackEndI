package com.dh.dentalClinic.persistence.repository;

import com.dh.dentalClinic.persistence.entities.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentsRepository extends MongoRepository<Appointment, Long> {
}

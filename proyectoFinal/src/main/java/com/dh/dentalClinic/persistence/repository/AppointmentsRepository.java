package com.dh.dentalClinic.persistence.repository;

import com.dh.dentalClinic.persistence.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment, Long> {
}

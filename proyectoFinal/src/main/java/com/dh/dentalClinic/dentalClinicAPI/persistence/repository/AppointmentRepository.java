package com.dh.dentalClinic.dentalClinicAPI.persistence.repository;

import com.dh.dentalClinic.dentalClinicAPI.persistence.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

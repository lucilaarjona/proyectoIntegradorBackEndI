package com.dh.clinica.persistence.repository;

import com.dh.clinica.persistence.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnosRepository extends JpaRepository<Turno, Long> {
}

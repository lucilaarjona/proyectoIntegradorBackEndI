package com.dh.dentalClinic.persistence.repository;

import com.dh.dentalClinic.persistence.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

package com.dh.dentalClinic.dentalClinicAPI.persistence.repository;

import com.dh.dentalClinic.dentalClinicAPI.persistence.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}

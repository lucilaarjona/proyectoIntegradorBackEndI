package com.dh.dentalClinic.persistence.repository;

import com.dh.dentalClinic.persistence.entities.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Address, Long> {
}

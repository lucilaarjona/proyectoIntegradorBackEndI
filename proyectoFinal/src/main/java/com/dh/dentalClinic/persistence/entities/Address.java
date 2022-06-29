package com.dh.dentalClinic.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString
@Document(collection = "address")

public class Address {

    @Id
    private Long id;
    private String street;

    private String number;

    private String locality;

    private String province;
    @Field(name = "patient")

    private Set<Patient> patients = new HashSet<>();
    public Address() {
    }

    public Address(String street, String number, String locality, String province) {
        this.street = street;
        this.number = number;
        this.locality = locality;
        this.province = province;
    }
}

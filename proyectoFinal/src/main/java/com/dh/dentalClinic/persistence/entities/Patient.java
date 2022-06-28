package com.dh.dentalClinic.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@ToString
@Document(collection = "patients")
public class Patient {
   @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String dni;

    private Date admissionDate;
    @Field(name = "address")
    private Address address;


    public Patient() {
    }

    public Patient(String firstName, String lastName, String dni, Date admissionDate) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.admissionDate = admissionDate;
    }
}

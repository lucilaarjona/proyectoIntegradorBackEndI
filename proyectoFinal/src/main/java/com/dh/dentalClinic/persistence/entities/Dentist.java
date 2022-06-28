package com.dh.dentalClinic.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Document(collection = "dentist")
public class Dentist {
    @Id

    private Long id;

    private String firstName;


    private String lastName;

    private Integer registration;

    @Field(name = "patient")
    private Set<Patient> patients = new HashSet<>();

    public Dentist() {
    }

    public Dentist(String name, String lastName, Integer registration) {
        this.firstName = name;
        this.lastName = lastName;
        this.registration = registration;
    }
}

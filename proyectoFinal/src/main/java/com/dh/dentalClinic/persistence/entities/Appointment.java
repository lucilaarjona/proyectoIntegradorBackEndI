package com.dh.dentalClinic.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Date;
@Setter
@Getter
@ToString
@Document(collection = "appointment")
public class Appointment {

    @Id
    private Long id;
    @Field(name = "patient")

    private Patient patient;
    @Field(name = "dentist")

    private Dentist dentist;

    private Date date;

    public Appointment() {
    }

    public Appointment(Patient patient, Dentist dentist, Date date) {
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
    }
}

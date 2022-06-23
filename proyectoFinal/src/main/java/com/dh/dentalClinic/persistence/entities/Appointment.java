package com.dh.dentalClinic.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private Patient patient;
    @Column
    private Dentist dentist;
    @Column
    private Date date;

    public Appointment() {
    }

    public Appointment(Patient patient, Dentist dentist, Date date) {
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patient=" + patient +
                ", dentist=" + dentist +
                ", date=" + date +
                '}';
    }
}

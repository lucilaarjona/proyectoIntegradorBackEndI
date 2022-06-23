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
    private String patient;
    @Column
    private String dentist;
    @Column
    private Date date;

    public Appointment() {
    }

    public Appointment(String patient, String dentist, Date date) {
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

package com.dh.dentalClinic.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@ToString

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String dni;

    @Column
    private Date admissionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id", nullable = false)
    private Dentist dentist;
    public Patient() {
    }

    public Patient(String firstName, String lastName, String dni, Date admissionDate) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.admissionDate = admissionDate;
    }
}

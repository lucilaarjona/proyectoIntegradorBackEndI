package com.dh.dentalClinic.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Entity
@Table
public class Patient {
    @Id
    @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String dni;
    @Column
    private Date admissionDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn(name = "address_id")
    private Address address;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;
    public Patient() {
    }

    public Patient(String firstName, String lastName, String dni, Date admissionDate) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.admissionDate = admissionDate;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", admissionDate=" + admissionDate +
                ", address=" + address +
                ", dentist=" + dentist +
                '}';
    }
}

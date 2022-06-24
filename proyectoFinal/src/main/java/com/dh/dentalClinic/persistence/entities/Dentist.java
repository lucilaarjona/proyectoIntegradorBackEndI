package com.dh.dentalClinic.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Dentist {
    @Id
    @SequenceGenerator(name = "dentist_sequence", sequenceName = "dentist_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentist_sequence")
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Integer registration;
    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY )
    private Set<Patient> patients = new HashSet<>();

    public Dentist() {
    }

    public Dentist(String name, String lastName, Integer registration) {
        this.firstName = name;
        this.lastName = lastName;
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registration=" + registration +
                ", patients=" + patients +
                '}';
    }
}

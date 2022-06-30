package com.dh.dentalClinic.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "dentists")
public class Dentist {
    @Id
    @SequenceGenerator(name = "dentist_sequence", sequenceName = "dentist_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentist_sequence")
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Integer registration;

    @OneToMany(mappedBy = "dentist", fetch = FetchType.EAGER )
    @JsonIgnore
    private Set<Patient> patients = new HashSet<>();

    public Dentist() {
    }

    public Dentist(String name, String lastName, Integer registration) {
        this.firstName = name;
        this.lastName = lastName;
        this.registration = registration;
    }
}

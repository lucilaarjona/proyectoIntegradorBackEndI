package com.dh.dentalClinic.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Address {
    @Id
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private Integer id;
    @Column
    private String street;
    @Column
    private String number;
    @Column
    private String locality;
    @Column
    private String province;
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private Set<Patient> patients = new HashSet<>();
    public Address() {
    }

    public Address(String street, String number, String locality, String province) {
        this.street = street;
        this.number = number;
        this.locality = locality;
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", locality='" + locality + '\'' +
                ", province='" + province + '\'' +
                ", patients=" + patients +
                '}';
    }
}

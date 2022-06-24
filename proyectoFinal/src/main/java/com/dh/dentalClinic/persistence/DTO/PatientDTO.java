package com.dh.dentalClinic.persistence.DTO;

import com.dh.dentalClinic.persistence.entities.Address;
import com.dh.dentalClinic.persistence.entities.Dentist;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private Date admissionDate;
    private Address address;
    private Dentist dentist;
}

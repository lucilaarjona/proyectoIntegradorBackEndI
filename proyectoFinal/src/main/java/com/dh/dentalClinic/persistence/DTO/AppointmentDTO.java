package com.dh.dentalClinic.persistence.DTO;

import com.dh.dentalClinic.persistence.entities.Dentist;
import com.dh.dentalClinic.persistence.entities.Patient;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter

public class AppointmentDTO {
    private Long id;
    private Patient patient;
    private Dentist dentist;
    private Date date;
}

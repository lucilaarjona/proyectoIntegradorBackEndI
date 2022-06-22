package com.dh.clinica.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String paciente;
    /*private Paciente paciente;*/
    @Column
    private String odontologo;
    /*private Odontologo odontologo;*/
    @Column
    private Date date;

    public Turno() {
    }

    public Turno(String paciente, String odontologo, Date date) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                ", date=" + date +
                '}';
    }
}

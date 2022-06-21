package com.dh.clinica.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Odontologo {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private Integer matricula;

    public Odontologo() {
    }

    public Odontologo(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}

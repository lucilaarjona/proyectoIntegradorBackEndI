package com.example.proyectoFinal.models;
import java.time.LocalDateTime;

public class Turno {

    private LocalDateTime fechaYHora;
    private Odontologo odontologo;

    public Turno(LocalDateTime fechaYHora, Odontologo odontologo) {
        this.fechaYHora = fechaYHora;
        this.odontologo = odontologo;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }
}

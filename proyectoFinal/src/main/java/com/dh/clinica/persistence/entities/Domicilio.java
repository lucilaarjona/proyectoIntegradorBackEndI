//package com.dh.clinica.persistence.entities;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Setter
//@Getter
//@Entity
//public class Domicilio {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Integer id;
//    @Column
//    private String calle;
//    @Column
//    private String numero;
//    @Column
//    private String localidad;
//    @Column
//    private String provincia;
//
//    public Domicilio() {
//    }
//
//    public Domicilio( String calle, String numero, String localidad, String provincia) {
//        this.calle = calle;
//        this.numero = numero;
//        this.localidad = localidad;
//        this.provincia = provincia;
//    }
//
//    @Override
//    public String toString() {
//        return "Domicilio{" +
//                "id=" + id +
//                ", calle='" + calle + '\'' +
//                ", numero='" + numero + '\'' +
//                ", localidad='" + localidad + '\'' +
//                ", provincia='" + provincia + '\'' +
//                '}';
//    }
//}

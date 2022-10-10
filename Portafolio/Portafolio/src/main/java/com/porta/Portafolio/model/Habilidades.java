package com.porta.Portafolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Habilidades")
public class Habilidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombreHabi;

    @Column(name = "porcentaje_habilidad")
    private int porcentaje;

   

    //constructor
    public Habilidades() {
    }

    public Habilidades(String nombreHabi, int porcentaje) {
        this.nombreHabi = nombreHabi;
        this.porcentaje = porcentaje;
        
    }

}

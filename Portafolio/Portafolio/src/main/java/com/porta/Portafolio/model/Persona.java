package com.porta.Portafolio.model;

import javax.persistence.*;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Persona") //nombre de la tabla en la base de datos, este es el mapeo
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") //indica en que columna esta en la base de datos
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "sobre_mi")
    private String sobreMi;

    @Column(name = "ocupacion")
    private String ocupacion;

   


    //de muchos a muchos
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "persona_imagenes",
            joinColumns = {
                @JoinColumn(name = "persona_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "file_id")
            })
    private Set<File> personaImagen;

  

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido, String sobreMi, String ocupacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sobreMi = sobreMi;
        this.ocupacion = ocupacion;
        
    }

}

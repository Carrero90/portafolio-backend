
package com.porta.Portafolio.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name="Proyectos") //nombre de la tabla en la base de datos, este es el mapeo
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name="id") //indica en que columna esta en la base de datos
    private int id;
    
    @Column(name="nombre")
    private String nombreProyec;
    
    @Column(name="desc_proyecto")
    private String descProyecto;
    
        
    @Column(name="url_pagina")
    private String urlPagina;
    
    
    //many to many con file
    @ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinTable(name = "proyecto_imagenes",
        joinColumns = {
            @JoinColumn(name="proyecto_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name="file_id")
        }
    )
    private Set<File> proyectoImagen;
   
       
    //constructor

    public Proyecto() {
    }

    public Proyecto(String nombreProyec, String descProyecto, String urlPagina) {
        this.nombreProyec = nombreProyec;
        this.descProyecto = descProyecto;
        this.urlPagina = urlPagina;
        
    }
   
    
    
}

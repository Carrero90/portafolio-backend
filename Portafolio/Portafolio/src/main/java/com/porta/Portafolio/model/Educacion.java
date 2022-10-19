
package com.porta.Portafolio.model;


import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
@Entity
@Table(name="Educacion") //nombre de la tabla en la base de datos, este es el mapeo
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="id") //indica en que columna esta en la base de datos
    private int id;
    
    @Column(name="nombre_universidad")
    private String nombreUniversidad;
    
    @Column(name="year_ingreso")
    private String yearIngreso;
    
    @Column(name="year_egreso")
    private String yearEgreso;
    
    @Column(name="carrera")
    private String carrera;
    
    @Column(name="descripcion", length = 600)
    private String descripcion;
    
       
    

    public Educacion() {
    }

    public Educacion(int id, String nombreUniversidad, String yearIngreso, String yearEgreso, String carrera, String descripcion) {
        this.id = id;
        this.nombreUniversidad = nombreUniversidad;
        this.yearIngreso = yearIngreso;
        this.yearEgreso = yearEgreso;
        this.carrera = carrera;
        this.descripcion = descripcion;
       
    }
    
    
   
    
}

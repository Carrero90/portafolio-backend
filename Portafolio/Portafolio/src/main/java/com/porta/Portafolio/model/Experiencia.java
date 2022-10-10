
package com.porta.Portafolio.model;

import com.sun.istack.NotNull;
import java.util.Date;
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

@Getter @Setter
@Entity
@Table(name="Experiencia_laboral")
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id") //indica en que columna esta en la base de datos
    private int id;
    
    @Column(name="nombre_empresa")
    private String nombreEmpresa;
    
    @Column(name="fecha_inicio")
    private String fechaInicio;
    
    @Column(name="fecha_fin")
    private String fechaFin;
    
    @Column(name="descripcion_laboral")
    private String descLaboral;
    
       
   
    
    
    //constructor

    public Experiencia() {
    }

    public Experiencia(String nombreEmpresa, String fechaInicio, String fechaFin, String descLaboral, String personaId) {
        this.nombreEmpresa = nombreEmpresa;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descLaboral = descLaboral;
    }   
    
    
        
}

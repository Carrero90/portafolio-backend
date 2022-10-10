package com.porta.Portafolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image_model") //nombre de la tabla en la base de datos, este es el mapeo
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") //indica en que columna esta en la base de datos
    private int id;

    @Column(name = "name") //indica en que columna esta en la base de datos
    private String name;

    @Column(name = "type") //indica en que columna esta en la base de datos
    private String type;

    @Column(length = 5000000) 
    private byte[] picByte;

    public File() {
    }

    public File(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
    
    
}

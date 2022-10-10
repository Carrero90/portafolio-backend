package com.porta.Portafolio.service;

import com.porta.Portafolio.model.Persona;
import java.util.List;


public interface IPersonaService {

    // traer una lista de personas
    public List<Persona> getPersonas();

    //buscar una persona por ID
    public Persona findPersona(int id);

    // guardar un objeto de tipo persona
    public Persona savePersona(Persona per);

    // eliminar un objeto pero lo buscamos por ID
    public void deletePersona(int id);
    
   

   

   
}

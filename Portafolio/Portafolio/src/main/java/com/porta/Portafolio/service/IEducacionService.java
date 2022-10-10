
package com.porta.Portafolio.service;


import com.porta.Portafolio.model.Educacion;
import java.util.List;


public interface IEducacionService {
    
     // traer una lista de Educacion
    public List<Educacion> getEducacion();
    
    //buscar una Educacion por ID
   public Educacion findEducacion(int id);
    
    // guardar un objeto de tipo Educacion
   public void saveEducacion(Educacion educa);
    
    // eliminar un objeto pero lo buscamos por ID
    public void deleteEducacion(int id);
}
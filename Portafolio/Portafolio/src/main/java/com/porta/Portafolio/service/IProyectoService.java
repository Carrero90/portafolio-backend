
package com.porta.Portafolio.service;


import com.porta.Portafolio.model.Proyecto;
import java.util.List;


public interface IProyectoService {
      // traer una lista de Proyecto
    public List<Proyecto> getProyecto();
    
    //buscar una Proyecto por ID
   public Proyecto findProyecto(int id);
    
    // guardar un objeto de tipo Proyecto
   public void saveProyecto(Proyecto proyec);
    
    // eliminar un objeto pero o buscamos por ID
    public void deleteProyecto (int id);
    
    
}

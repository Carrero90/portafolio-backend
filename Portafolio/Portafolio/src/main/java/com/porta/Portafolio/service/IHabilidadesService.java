
package com.porta.Portafolio.service;


import com.porta.Portafolio.model.Habilidades;
import java.util.List;


public interface IHabilidadesService {
     // traer una lista de Habilidades
    public List<Habilidades> getHabilidades();
    
    //buscar una Habilidades por ID
   public Habilidades findHabilidades(int id);
    
    // guardar un objeto de tipo Habilidades
   public void saveHabilidades(Habilidades habi);
    
    // eliminar un objeto pero lo buscamos por ID
    public void deleteHabilidades (int id);
    
    
}

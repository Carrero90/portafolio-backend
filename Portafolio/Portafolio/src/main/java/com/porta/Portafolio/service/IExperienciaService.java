
package com.porta.Portafolio.service;



import com.porta.Portafolio.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    
       // traer una lista de Experiencia
    public List<Experiencia> getExperiencia();
    
    //buscar una Experiencia por ID
   public Experiencia findExperiencia(int id);
    
    // guardar un objeto de tipo Experiencia
   public void saveExperiencia(Experiencia expe);
    
    // eliminar un objeto pero lo buscamos por ID
    public void deleteExperiencia (int id);
    
}

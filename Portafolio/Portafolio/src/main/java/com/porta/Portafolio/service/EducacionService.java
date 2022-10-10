
package com.porta.Portafolio.service;

import com.porta.Portafolio.model.Educacion;
import com.porta.Portafolio.repository.EducacionRepository;
import com.porta.Portafolio.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{

    private EducacionRepository educaRepo;
    
    //constructor
    @Autowired
    public EducacionService (EducacionRepository educaRepo) {
        this.educaRepo = educaRepo;
    } 
    
    //obtener listas de Educacion
    @Override
    public List<Educacion> getEducacion() {
        return educaRepo.findAll();
    }

    //obtener Educacion por id
    @Override
    public Educacion findEducacion(int id) {
        Optional<Educacion> result = educaRepo.findById(id);
        
         Educacion educa = null;
         if(result.isPresent()){
            educa = result.get();
        }
          else {
            throw new RuntimeException("no se encontró la persona");
        }
        return educa;
    }
    //guardar Educacion
    @Override
    public void saveEducacion(Educacion educa) {
        educaRepo.save(educa);
    }

    //para eliminar Educacion
    @Override
    public void deleteEducacion(int id) {
        educaRepo.deleteById(id);
    }
    
}


    
   
        
        
       
        
       
   
    
        
    
   

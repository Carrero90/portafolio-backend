
package com.porta.Portafolio.service;

import com.porta.Portafolio.model.Experiencia;
import com.porta.Portafolio.repository.ExperienciaRepository;
import com.porta.Portafolio.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ExperienciaService implements IExperienciaService {

     private ExperienciaRepository expeRepo;
    
    //constructor
    @Autowired
    public ExperienciaService (ExperienciaRepository expeRepo) {
        this.expeRepo = expeRepo;
    } 
    //obtener listas de experiencia
    @Override
    public List<Experiencia> getExperiencia() {
        return expeRepo.findAll();
    }
    
    //obtener experiencia por id
    @Override
    public Experiencia findExperiencia(int id) {
        Optional<Experiencia> result = expeRepo.findById(id);
        
        Experiencia expe = null;
        if(result.isPresent()){
            expe = result.get();
        }
        else {
            throw new RuntimeException("no se encontró la persona");
        }
        return expe;
    }
    
    //guardar  experiencia
    @Override
    public void saveExperiencia(Experiencia expe) {
        expeRepo.save(expe);
    }
    
    //para eliminar experiencia
    @Override
    public void deleteExperiencia(int id) {
        expeRepo.deleteById(id);
    }

    
}

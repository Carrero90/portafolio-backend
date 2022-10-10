
package com.porta.Portafolio.service;

import com.porta.Portafolio.model.Habilidades;
import com.porta.Portafolio.repository.HabilidadesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadesService implements IHabilidadesService{
    
    private HabilidadesRepository habirepo;
    
    //constructor
    
    @Autowired
    public HabilidadesService (HabilidadesRepository habirepo) {
        this.habirepo = habirepo;
    } 
    
    
    //lista de habilidades
    @Override
    public List<Habilidades> getHabilidades() {
        return habirepo.findAll();
    }
    
    //habilidad por id
    @Override
    public Habilidades findHabilidades(int id) {
        Optional<Habilidades> result = habirepo.findById(id);
        
        Habilidades habil = null;
        if(result.isPresent()){
            habil = result.get();
        }
        else {
            throw new RuntimeException("no se encontró la persona");
        }
        return habil;
    }
    
    
    //guardar habilidad
    @Override
    public void saveHabilidades(Habilidades habi) {
        habirepo.save(habi);
    }

    
    //eliminar habilidad
    @Override
    public void deleteHabilidades(int id) {
        habirepo.deleteById(id);
    }
    
}

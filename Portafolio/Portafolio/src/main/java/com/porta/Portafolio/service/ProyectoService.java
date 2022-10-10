
package com.porta.Portafolio.service;

import com.porta.Portafolio.model.Persona;
import com.porta.Portafolio.model.Proyecto;
import com.porta.Portafolio.repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {

    private ProyectoRepository proyeRepo;
    
    //constructor 
    public ProyectoService (ProyectoRepository proyeRepo) {
        this.proyeRepo = proyeRepo;
    } 
    
    // lista de proyectos
    @Override
    public List<Proyecto> getProyecto() {
        return proyeRepo.findAll();
    }
    
    //proyecto
    @Override
    public Proyecto findProyecto(int id) {
        Optional<Proyecto> result = proyeRepo.findById(id);
        
        Proyecto proyec = null;
        if(result.isPresent()){
            proyec = result.get();
        }
        else {
            throw new RuntimeException("no se encontró la persona");
        }
        return proyec;
    }
    
    //guardar proyecto
    @Override
    public void saveProyecto(Proyecto proyec) {
        proyeRepo.save(proyec);
    }
    
    //eliminar proyecto
    @Override
    public void deleteProyecto(int id) {
        proyeRepo.deleteById(id);
    }
    
}

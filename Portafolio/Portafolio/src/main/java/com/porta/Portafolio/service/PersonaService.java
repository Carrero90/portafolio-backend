package com.porta.Portafolio.service;

import com.porta.Portafolio.model.Persona;
import com.porta.Portafolio.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    private PersonaRepository persoRepo;

    //constructor
    @Autowired
    public PersonaService(PersonaRepository persoRepo) {
        this.persoRepo = persoRepo;
    }

    //obtener listas de personas
    @Override
    public List<Persona> getPersonas() {
        return persoRepo.findAll();

    }

    //obtener persona por id
    @Override
    public Persona findPersona(int id) {
        Optional<Persona> result = persoRepo.findById(id);

        Persona perso = null;
        if (result.isPresent()) {
            perso = result.get();
        } else {
            throw new RuntimeException("no se encontró la persona");
        }
        return perso;
    }

    //guardar personas
    @Override
    public Persona savePersona(Persona per) {
        return persoRepo.save(per);
    }

    //para eliminar persona
    @Override
    public void deletePersona(int id) {
        persoRepo.deleteById(id);
    }

  

}

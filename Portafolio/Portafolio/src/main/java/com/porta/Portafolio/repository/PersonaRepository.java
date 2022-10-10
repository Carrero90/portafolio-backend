package com.porta.Portafolio.repository;

import com.porta.Portafolio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;



@Repository
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel="Persona", path="persona")
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    
}

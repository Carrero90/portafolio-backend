
package com.porta.Portafolio.repository;

import com.porta.Portafolio.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel="Proyecto", path="proyectos")
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{
    
}

package com.porta.Portafolio.repository;


import com.porta.Portafolio.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;



@Repository
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel="Educacion", path="educations")
public interface EducacionRepository extends JpaRepository<Educacion, Integer>{
    
}

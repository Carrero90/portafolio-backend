
package com.porta.Portafolio.repository;

import com.porta.Portafolio.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@Repository
@CrossOrigin("http://localhost:4200")
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer>{
    
}

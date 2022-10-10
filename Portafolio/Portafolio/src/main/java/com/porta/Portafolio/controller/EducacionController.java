
package com.porta.Portafolio.controller;

import com.porta.Portafolio.model.Educacion;
import com.porta.Portafolio.service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portafolio")
@CrossOrigin("http://localhost:4200")
public class EducacionController {
  
        private IEducacionService educaServ;
    
    //constructor
    @Autowired
    public EducacionController (IEducacionService theeducaServ){
        educaServ = theeducaServ;
    }
        
    //devolver lista de educacion
    @GetMapping("/educacion")
    public List<Educacion> getEducacion(){
        return educaServ.getEducacion();
    }
    
    //devolver educacion por id
    @GetMapping("/educacion/{id}")
    public Educacion findEducacion(@PathVariable int id){
        Educacion theEduca = educaServ.findEducacion(id);
        
        if(theEduca == null){
            throw new RuntimeException("no se encontró la persona con el id " + id);
        }
        return theEduca;
    }
    
    //agregar nueva educacion a la base de datos
    @PostMapping("/saveeducacion")
    public Educacion saveEducacion(@RequestBody Educacion theEduca){
        //para forzar que se guarde y no lo tome como una actualizacion le pasamos el st id 0
        
        theEduca.setId(0);
        educaServ.saveEducacion(theEduca);
        
        return theEduca;
    }
    
    //actualizar educacion
    @PutMapping("/upeducacion/{id}")
    public Educacion updateEducacion(@PathVariable("id") int id, @RequestBody Educacion theEducaN){
        Educacion theEduca = educaServ.findEducacion(id);
        
        theEduca.setNombreUniversidad(theEducaN.getNombreUniversidad());
        theEduca.setYearIngreso(theEducaN.getYearIngreso());
        theEduca.setYearEgreso(theEducaN.getYearEgreso());
        theEduca.setCarrera(theEducaN.getCarrera());
        theEduca.setDescripcion(theEducaN.getDescripcion());

                
        educaServ.saveEducacion(theEduca);
        
        return theEduca;
    }
    
    //eliminar educacion
    
    @DeleteMapping("/deleteducacion/{id}")
        public void deleteEducacion(@PathVariable int id){
            Educacion theEduca = educaServ.findEducacion(id);
            //si es nulo
            
            if(theEduca == null){
                 throw new RuntimeException("no se encontró la persona con el id " + id);
            }
            
            educaServ.deleteEducacion(id);
           
    }
    
}


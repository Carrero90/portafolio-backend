package com.porta.Portafolio.controller;

import com.porta.Portafolio.model.Experiencia;
import com.porta.Portafolio.service.IExperienciaService;
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
public class ExperienciaController {

    private IExperienciaService experServ;

    //constructor
    @Autowired
    public ExperienciaController(IExperienciaService theExperServ) {
        experServ = theExperServ;
    }

    //devolver lista de experiencia
    @GetMapping("/experiencia")
    public List<Experiencia> getExperiencia() {
        return experServ.getExperiencia();
    }

    //devolver experiencia por id
    @GetMapping("/experiencia/{id}")
    public Experiencia findExperiencia(@PathVariable int id) {
        Experiencia theExper = experServ.findExperiencia(id);

        if (theExper == null) {
            throw new RuntimeException("no se encontró la persona con el id " + id);
        }
        return theExper;
    }

    //agregar nueva experiencia a la base de datos
    @PostMapping("/saveexperiencia")
    public Experiencia saveExperiencia(@RequestBody Experiencia theExper) {
        //para forzar que se guarde y no lo tome como una actualizacion le pasamos el st id 0

        theExper.setId(0);
        experServ.saveExperiencia(theExper);

        return theExper;
    }

    //actualizar experiencia
    @PutMapping("/upexperiencia/{id}")
    public Experiencia updateExperiencia(@PathVariable("id") int id, @RequestBody Experiencia theExperN) {
        Experiencia theExper = experServ.findExperiencia(id);
        
        theExper.setNombreEmpresa(theExperN.getNombreEmpresa());
        theExper.setFechaInicio(theExperN.getFechaInicio());
        theExper.setFechaFin(theExperN.getFechaFin());
        theExper.setDescLaboral(theExperN.getDescLaboral());
        
        experServ.saveExperiencia(theExper);

        return theExper;
    }

    //eliminar experiencia
    @DeleteMapping("/deletexperiencia/{id}")
    public void deleteExperiencia(@PathVariable int id) {
        Experiencia theExper = experServ.findExperiencia(id);
        //si es nulo

        if (theExper == null) {
            throw new RuntimeException("no se encontró la persona con el id " + id);
        }

        experServ.deleteExperiencia(id);

    }

}

package com.porta.Portafolio.controller;

import com.porta.Portafolio.model.Habilidades;
import com.porta.Portafolio.service.IHabilidadesService;
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
@CrossOrigin("https://my-porfolio-cea8f.web.app")
public class HabilidadesController {

    private IHabilidadesService habicServ;

    //constructor
    @Autowired
    public HabilidadesController(IHabilidadesService thehabiServ) {
        habicServ = thehabiServ;
    }

    //devolver lista de habilidad
    @GetMapping("/habilidad")
    public List<Habilidades> getHabilidades() {
        return habicServ.getHabilidades();
    }

    //devolver habilidad por id
    @GetMapping("/habilidad/{id}")
    public Habilidades findHabilidades(@PathVariable int id) {
        Habilidades theHabi = habicServ.findHabilidades(id);

        if (theHabi == null) {
            throw new RuntimeException("no se encontró la persona con el id " + id);
        }
        return theHabi;
    }

    //agregar nueva habilidad a la base de datos
    @PostMapping("/savehabi")
    public Habilidades saveHabilidades(@RequestBody Habilidades theHabi) {
        //para forzar que se guarde y no lo tome como una actualizacion le pasamos el st id 0

        theHabi.setId(0);
        habicServ.saveHabilidades(theHabi);

        return theHabi;
    }

    //actualizar habilidad
    @PutMapping("/uphabilidad/{id}")
    public Habilidades updateHabilidades(@PathVariable("id") int id, @RequestBody Habilidades theHabiN) {
        Habilidades theHabi = habicServ.findHabilidades(id);
        
        theHabi.setNombreHabi(theHabiN.getNombreHabi());
        theHabi.setPorcentaje(theHabiN.getPorcentaje());
        
        
        
        habicServ.saveHabilidades(theHabi);

        return theHabi;
    }

    //eliminar habilidad
    @DeleteMapping("/delethabilidad/{id}")
    public void deleteHabilidades(@PathVariable int id) {
        Habilidades theHabi = habicServ.findHabilidades(id);
        //si es nulo

        if (theHabi == null) {
            throw new RuntimeException("no se encontró la persona con el id " + id);
        }

        habicServ.deleteHabilidades(id);

    }
}

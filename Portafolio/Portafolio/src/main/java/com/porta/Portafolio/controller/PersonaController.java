package com.porta.Portafolio.controller;

import com.porta.Portafolio.model.File;
import com.porta.Portafolio.model.Persona;
import com.porta.Portafolio.service.IPersonaService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/portafolio")
@CrossOrigin("https://my-porfolio-cea8f.web.app")
public class PersonaController {

    private IPersonaService persoServ;
    

    //constructor
    @Autowired
    public PersonaController(IPersonaService thepersoServ) {
        persoServ = thepersoServ;
    }

    //devolver lista de personas
    @GetMapping("/personas")
    public List<Persona> getPersonas() {
        return persoServ.getPersonas();
    }

    //devolver persona por id
    @GetMapping("/personas/{id}")
    public Persona findPersona(@PathVariable int id) {
        Persona thepersona = persoServ.findPersona(id);
        
        if (thepersona == null) {
            throw new RuntimeException("no se encontró la persona con el id " + id);
        }
        return thepersona;
    }

    //agregar nueva persona a la base de datos
    @PostMapping(value = "/savepersona", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Persona savePersona(@RequestPart("thePersona") Persona thePersona, @RequestPart("imagenFile") MultipartFile[] file) {
        //para forzar que se guarde y no lo tome como una actualizacion le pasamos el st id 0
        
        
        try {
            Set<File> images = uploadImagen(file);
            thePersona.setPersonaImagen(images);
            thePersona.setId(0);
            persoServ.savePersona(thePersona);
            return thePersona;
        } catch (Exception e) {
            System.out.println(e.getMessage());
             return null;
        }

        
    }

    public Set<File> uploadImagen(MultipartFile[] multipartFiles) throws IOException{
        Set<File> files = new HashSet<>();

        for (MultipartFile file : multipartFiles) {
            File imFile = new File(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            files.add(imFile);
        }
        return files;
    }

    //actualizar persona
    @PutMapping("/uppersona/{id}")
    public Persona updatePersona(@PathVariable("id") int id, @RequestPart("thePersona") Persona thePersonaN, @RequestPart("imagenFile") MultipartFile[] file) throws IOException  {
        
        Persona thepersona = persoServ.findPersona(id);
        Set<File> images = uploadImagen(file);
              
        thepersona.setNombre(thePersonaN.getNombre());
        thepersona.setApellido(thePersonaN.getApellido());
        thepersona.setOcupacion(thePersonaN.getOcupacion());
        thepersona.setSobreMi(thePersonaN.getSobreMi());
        thepersona.setPersonaImagen(images);
        
        persoServ.savePersona(thepersona);
        
        return thepersona;

    }

    //eliminar personas
    @DeleteMapping("/deletpersona/{id}")
    public void deletePersona(@PathVariable int id) {
        Persona thePersona = persoServ.findPersona(id);
        //si es nulo

        if (thePersona == null) {
            throw new RuntimeException("no se encontró la persona con el id " + id);
        }

        persoServ.deletePersona(id);

    }

}

package com.porta.Portafolio.controller;

import com.porta.Portafolio.model.File;
import com.porta.Portafolio.model.Proyecto;
import com.porta.Portafolio.service.IProyectoService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/portafolio")
@CrossOrigin("http://localhost:4200")
public class ProyectoController {

    private IProyectoService proyecServ;

    //constructor
    @Autowired
    public ProyectoController(IProyectoService theproyecServ) {
        proyecServ = theproyecServ;
    }

    //devolver lista de proyecto
    @GetMapping("/proyecto")
    public List<Proyecto> getProyecto() {
        return proyecServ.getProyecto();
    }

    //devolver proyecto por id
    @GetMapping("/proyecto/{id}")
    public Proyecto findProyecto(@PathVariable int id) {
        Proyecto theProyec = proyecServ.findProyecto(id);

        if (theProyec == null) {
            throw new RuntimeException("no se encontró la persona con el id " + id);
        }
        return theProyec;
    }

    //agregar nueva proyecto a la base de datos
    @PostMapping(value = {"/saveproyecto"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Proyecto saveProyecto(@RequestPart("theProyec") Proyecto theProyec, @RequestPart("imageFile") MultipartFile[] file) {
        //para forzar que se guarde y no lo tome como una actualizacion le pasamos el st id 0

        try {
            Set<File> images = uploadImage(file);
            theProyec.setProyectoImagen(images);
            theProyec.setId(0);
            proyecServ.saveProyecto(theProyec);
            return theProyec;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Set<File> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<File> imageModels = new HashSet<>();

        for (MultipartFile file : multipartFiles) {
            File imageModel = new File(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }

    //actualizar proyecto
    @PutMapping("/upproyecto/{id}")
    public Proyecto updateProyecto(@PathVariable("id") int id, @RequestPart("theProyec") Proyecto theProyecN, @RequestPart("imageFile") MultipartFile[] file) throws IOException {
        Proyecto theProyec = proyecServ.findProyecto(id);
        Set<File> images = uploadImage(file);
        
        theProyec.setNombreProyec(theProyecN.getNombreProyec());
        theProyec.setDescProyecto(theProyecN.getDescProyecto());
        theProyec.setUrlPagina(theProyecN.getUrlPagina());
        theProyec.setProyectoImagen(images);

        proyecServ.saveProyecto(theProyec);

        return theProyec;
    }

    //eliminar proyecto
    @DeleteMapping("/deletproyecto/{id}")
    public void deleteProyecto(@PathVariable int id) {
        Proyecto theProyec = proyecServ.findProyecto(id);
        //si es nulo

        if (theProyec == null) {
            throw new RuntimeException("no se encontró la persona con el id " + id);
        }

        proyecServ.deleteProyecto(id);

    }
}

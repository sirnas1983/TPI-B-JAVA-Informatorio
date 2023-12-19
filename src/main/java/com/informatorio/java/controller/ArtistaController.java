package com.informatorio.java.controller;


import com.informatorio.java.service.artista.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.informatorio.java.dto.artista.ArtistaDTO;

@RestController
@RequestMapping(value = "/api/v1/artistas",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class ArtistaController {

    @Autowired
    ArtistaService artistaService;

    //Solicitado
    @GetMapping("/{idArtista}")
    @ResponseBody
    ArtistaDTO traerArtistaPorId(@PathVariable String idArtista){
        return artistaService.traerPorId(idArtista);
    }

}

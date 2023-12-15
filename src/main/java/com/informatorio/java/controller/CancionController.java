package com.informatorio.java.controller;

import com.informatorio.java.dto.CancionDTO;
import com.informatorio.java.service.cancion.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/canciones", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CancionController {


    @Autowired
    CancionService cancionService;


    @GetMapping
    @ResponseBody
    public List<CancionDTO> getCanciones(){
        return cancionService.traerTodos();
    }

    @GetMapping("/{idCancion}")
    @ResponseBody
    public CancionDTO getCancionPorId(@PathVariable String idCancion){
        return cancionService.traerPorId(idCancion);
    }

    @PostMapping
    public void nuevaCancion(@RequestBody CancionDTO cancionDTO){

        cancionService.cargar(cancionDTO);
    }



}

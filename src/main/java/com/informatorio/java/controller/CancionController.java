package com.informatorio.java.controller;

import com.informatorio.java.constants.ConstantsUtils;
import com.informatorio.java.dto.cancion.CancionDTO;
import com.informatorio.java.dto.response.RespuestaDTO;
import com.informatorio.java.service.cancion.CancionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/canciones", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CancionController {

    @Autowired
    CancionService cancionService;

    //Solicitado
    @GetMapping("/{idCancion}")
    @ResponseBody
    public CancionDTO getCancionPorId(@PathVariable String idCancion){
        return cancionService.traerPorId(idCancion);
    }

    //Solicitado
    @PostMapping
    public ResponseEntity<RespuestaDTO> nuevaCancion(@RequestBody @Valid CancionDTO cancionDTO){

        boolean operacionExitosa = cancionService.cargar(cancionDTO);
        if (operacionExitosa){
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new RespuestaDTO(ConstantsUtils.STATUS_201, ConstantsUtils.MESSAGE_201));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new RespuestaDTO(ConstantsUtils.STATUS_500, ConstantsUtils.MESSAGE_500));
        }
    }

    //Solicitado
    @GetMapping
    @ResponseBody
    public List<CancionDTO> listaCancionesPorGeneroArtistaTituloAlbum(
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) String artista,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String album){

        return cancionService.buscarPorGeneroArtistaTituloAlbum(genero, artista, titulo, album);
    }
}

package com.informatorio.java.controller;


import com.informatorio.java.constants.ConstantsUtils;
import com.informatorio.java.dto.listaReproduccion.ListaReproduccionDTO;
import com.informatorio.java.dto.listaReproduccion.ListaReproduccionUsuarioDTO;
import com.informatorio.java.dto.response.RespuestaDTO;
import com.informatorio.java.service.listaReproduccion.ListaReproduccionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/listas-reproduccion", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ListaReproduccionController {

    @Autowired
    ListaReproduccionService listaReproduccionService;

    //Solicitado
    @PostMapping("/usuario/{idUsuario}")
    public ResponseEntity<RespuestaDTO> crearListaReproduccion(
            @RequestParam String nombre,
            @RequestBody List<String> listaIdCanciones,
            @PathVariable(name = "idUsuario") String idUsuario){

        boolean operacionExitosa =  listaReproduccionService.nuevaLista(nombre, listaIdCanciones, idUsuario);

        if (operacionExitosa){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new RespuestaDTO(ConstantsUtils.STATUS_201, ConstantsUtils.MESSAGE_201));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new RespuestaDTO(ConstantsUtils.STATUS_500, ConstantsUtils.MESSAGE_500));
        }

    }

    //Solicitado
    @GetMapping("/usuario/{idUsuario}")
    @ResponseBody
    public List<ListaReproduccionUsuarioDTO> buscarListasReproduccion(
            @PathVariable(name = "idUsuario") String idUsuario){

        return listaReproduccionService.traerListasUsuario(idUsuario);
    }


    // Endpoint para poder extraer ID de lista de reproduccion
    // para las pruebas
    @GetMapping
    @ResponseBody
    public List<ListaReproduccionUsuarioDTO> getListasReproduccion(
            @RequestParam(name = "nombre", required = false) String nombre){

        return listaReproduccionService.buscarPorNombre(nombre);
    }

    //Solicitado
    @GetMapping("/{idListaReproduccion}")
    @ResponseBody
    public ListaReproduccionDTO getListaReproduccionPorID(@PathVariable(name = "idListaReproduccion") String id) {

        return listaReproduccionService.traerPorId(id);
    }


    //Solicitado
    @PutMapping("/{idListaReproduccion}")
    public ResponseEntity<RespuestaDTO> modificarEstadoListaReproduccion(
            @PathVariable(name = "idListaReproduccion") String idListaReproduccion,
            @RequestParam(name = "aleatorio", required = false) boolean aleatorio,
            @RequestParam(name = "repetir", required = false) boolean repetir,
            @RequestParam(name = "publica", required = false) boolean publica,
            @RequestBody(required = false) List<String> listaIdCanciones){

        boolean operacionExitosa = listaReproduccionService.modificarListaReproduccion(
                idListaReproduccion, aleatorio,  publica, repetir, listaIdCanciones
        );

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
}

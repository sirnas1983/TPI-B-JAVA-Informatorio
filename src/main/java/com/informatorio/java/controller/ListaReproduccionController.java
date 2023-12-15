package com.informatorio.java.controller;


import com.informatorio.java.constants.ConstantsUtils;
import com.informatorio.java.dto.listaReproduccion.ListaReproduccionDTO;
import com.informatorio.java.dto.RespuestaDTO;
import com.informatorio.java.service.listaReproduccion.ListaReproduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Se debe permitir listar las listas de reproducción de un usuario indicando su id. El listado debe estar ordenado por fecha de creación.
Se debe permitir listar las canciones de la lista de reproducción. Indicando con el id la lista de reproducción.
Se debe permitir crear una lista de reproducción pasando un listado de canciones y nombre.
Se debe permitir indicar si la playlist es pública, si se puede repetir la lista al finalizar y si esta se puede reproducir aleatoriamente.
Se debe permitir eliminar y/o agregar canciones a la lista, indicando id de la lista de reproducción e id de la canción.
*/

@RestController
@RequestMapping(value = "/api/v1/listas-reproduccion", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ListaReproduccionController {

    @Autowired
    ListaReproduccionService listaReproduccionService;


    // HECHO: Se debe permitir crear una lista de reproducción pasando un listado de canciones y nombre.
    @PostMapping("/usuario/{idUsuario}")
    @ResponseBody
    public void crearListaReproduccion(
            @RequestParam String nombre,
            @RequestBody List<String> listaIdCanciones,
            @PathVariable(name = "idUsuario") String idUsuario){

        listaReproduccionService.nuevaLista(nombre, listaIdCanciones, idUsuario);


    }

    @GetMapping
    public ResponseEntity<List<ListaReproduccionDTO>> getListasReproduccion(){

        List<ListaReproduccionDTO> listasReproduccionDTOS = listaReproduccionService.traerTodos();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listasReproduccionDTOS);
    }

    // HECHO: Se debe permitir listar las canciones de la lista de reproducción. Indicando con el id la lista de reproducción.
    @GetMapping("/{idListaReproduccion}")
    public ResponseEntity<ListaReproduccionDTO> getListaReproduccionPorID(@PathVariable(name = "idListaReproduccion") String id){

        ListaReproduccionDTO listaReproduccionDTO = listaReproduccionService.traerPorId(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listaReproduccionDTO);
    }

    // TODO: -Falta ordenar lista- Se debe permitir listar las listas de reproducción de un usuario indicando su id. El listado debe estar ordenado por fecha de creación.
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ListaReproduccionDTO>> getListaReproduccionUsuario(@PathVariable(name = "idUsuario") String idUsuario) {

        List<ListaReproduccionDTO> listasReproduccionDTO = listaReproduccionService.traerListasUsuario(idUsuario);

        return ResponseEntity
                 .status(HttpStatus.OK)
                 .body(listasReproduccionDTO);
    }

    // HECHO: Se debe permitir indicar si la playlist es pública, si se puede repetir la lista al finalizar y si esta se puede reproducir aleatoriamente.
    @PutMapping("/{idListaReproduccion}")
    @ResponseBody
    public void modificarEstadoListaReproduccion(
            @PathVariable(name = "idListaReproduccion") String idListaReproduccion,
            @RequestParam(name = "aleatorio", required = false) boolean aleatorio,
            @RequestParam(name = "repetir", required = false) boolean repetir,
            @RequestParam(name = "publica", required = false) boolean publica){

        listaReproduccionService.modificarEstadoListaReproduccion(
                idListaReproduccion, aleatorio,  publica, repetir
        );
    }

    // HECHO: Se debe permitir eliminar y/o agregar canciones a la lista, indicando id de la lista de reproducción e id de la canción.
    @PutMapping("/{idListaReproduccion}/{idCancion}")
    public ResponseEntity<RespuestaDTO> modificarListaReproduccion(
            @PathVariable(name = "idListaReproduccion") String idListaReproduccion,
            @PathVariable(name = "idCancion") String idCancion){

        listaReproduccionService.modificarListaReproduccion(idListaReproduccion, idCancion);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RespuestaDTO(ConstantsUtils.STATUS_201,ConstantsUtils.MESSAGE_201));
    }
}

package com.informatorio.java.controller;

import com.informatorio.java.dto.UsuarioDTO;
import com.informatorio.java.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Perfil de Usuario: Cada usuario tiene un perfil donde este tiene listas de reproducción
compuestas por canciones.
1.	Se debe permitir la creación de usuarios. Cada usuario tiene un id, nombre de usuario único
y puede o no tener lista de reproducción
2.	Se debe permitir obtener la información del usuario, junto con las listas de reproducción
que tenga. De cada playlist solo me interesa su nombre, id y cantidad de canciones.
*/

@RestController
@RequestMapping(value = "/api/v1/usuarios", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UsuarioController {


    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getUsuarios(){

        List<UsuarioDTO> listaUsuarios = usuarioService.traerTodos();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listaUsuarios);
    }

    @PostMapping
    @ResponseBody
    // HECHO: Se debe permitir la creación de usuarios. Cada usuario tiene un id, nombre de usuario único
    // y puede o no tener lista de reproducción
    public void crearUsuario(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.cargar(usuarioDTO);
    }

    @GetMapping("/{idUsuario}")
    @ResponseBody
    // HECHO: Se debe permitir obtener la información del usuario, junto con las listas de reproducción
    // que tenga. De cada playlist solo me interesa su nombre, id y cantidad de canciones.
    public UsuarioDTO verUsuario(@PathVariable String idUsuario){

        return usuarioService.traerPorId(idUsuario);

    }








}

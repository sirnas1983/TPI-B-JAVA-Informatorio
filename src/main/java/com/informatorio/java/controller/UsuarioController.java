package com.informatorio.java.controller;

import com.informatorio.java.constants.ConstantsUtils;
import com.informatorio.java.dto.response.RespuestaDTO;
import com.informatorio.java.dto.usuario.UsuarioDTO;
import com.informatorio.java.service.usuario.UsuarioService;
import jakarta.validation.Valid;
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

    // Endpoint para poder extraer ID de usuario
    // para las pruebas
    @GetMapping
    @ResponseBody
    public List<UsuarioDTO> getUsuarios(){
        return usuarioService.traerTodos();
    }

    //Solicitado
    @PostMapping
    public ResponseEntity<RespuestaDTO> crearUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO){
        boolean operacionExitosa = usuarioService.cargar(usuarioDTO);

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
    @GetMapping("/{idUsuario}")
    @ResponseBody
    // HECHO: Se debe permitir obtener la información del usuario, junto con las listas de reproducción
    // que tenga. De cada playlist solo me interesa su nombre, id y cantidad de canciones.
    public UsuarioDTO verUsuario(@PathVariable String idUsuario){
        return usuarioService.traerPorId(idUsuario);
    }
}
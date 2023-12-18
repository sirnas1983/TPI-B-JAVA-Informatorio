package com.informatorio.java.service.usuario;

import com.informatorio.java.dto.usuario.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    UsuarioDTO traerPorId(String id);
    List<UsuarioDTO> traerTodos();
    void modificar(UsuarioDTO usuarioDTO);
    boolean cargar(UsuarioDTO usuarioDTO);
    void eliminar(UsuarioDTO usuarioDTO);

}

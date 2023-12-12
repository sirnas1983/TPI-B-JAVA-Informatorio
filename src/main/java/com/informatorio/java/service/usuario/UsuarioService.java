package com.informatorio.java.service.usuario;

import com.informatorio.java.dto.UsuarioDTO;
import com.informatorio.java.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    UsuarioDTO traerPorId(String id);
    List<UsuarioDTO> traerTodos();
    void modificar(UsuarioDTO usuarioDTO);
    void cargar(UsuarioDTO usuarioDTO);
    void eliminar(UsuarioDTO usuarioDTO);

}

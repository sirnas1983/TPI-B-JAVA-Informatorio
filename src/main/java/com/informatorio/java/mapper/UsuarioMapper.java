package com.informatorio.java.mapper;

import com.informatorio.java.dto.UsuarioDTO;
import com.informatorio.java.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {


    public UsuarioDTO mapToUsuarioDTO(Usuario usuario){

        ListaReproduccionMapper listaReproduccionMapper = new ListaReproduccionMapper();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuarioDTO.setListasReproduccionDTO(listaReproduccionMapper.mapToListasDeReproduccionDTO(usuario.getListasDeReproduccion())); // TODO: crear metodo mapToListasReproduccionDTO

        return usuarioDTO;
    }

    public Usuario mapToUsuario(UsuarioDTO usuarioDTO){

        ListaReproduccionMapper listaReproduccionMapper = new ListaReproduccionMapper();

        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuario.setListasDeReproduccion(listaReproduccionMapper.mapToListasDeReproduccion(usuarioDTO.getListasReproduccionDTO())); // TODO: crear metodo mapToListasReproduccion

        return usuario;
    }

    public List<UsuarioDTO> mapToListaUsuariosDTO(List<Usuario> listaUsuarios){
        List<UsuarioDTO> listaUsuariosDTO = new ArrayList<>();
        for(Usuario usuario : listaUsuarios){
            listaUsuariosDTO.add(mapToUsuarioDTO(usuario));
        }
        return listaUsuariosDTO;
    }


}

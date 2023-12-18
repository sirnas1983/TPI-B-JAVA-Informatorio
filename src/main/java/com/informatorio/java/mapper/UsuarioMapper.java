package com.informatorio.java.mapper;

import com.informatorio.java.dto.usuario.UsuarioDTO;
import com.informatorio.java.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UsuarioMapper {


    public static UsuarioDTO mapToUsuarioDTO(Usuario usuario){

        ListaReproduccionMapper listaReproduccionMapper = new ListaReproduccionMapper();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDTO.setListasReproduccionDTO(listaReproduccionMapper.mapToListasDeReproduccionUsuarioDTO(usuario.getListasDeReproduccion()));
        return usuarioDTO;
    }

    public static Usuario mapToUsuario(UsuarioDTO usuarioDTO){

        ListaReproduccionMapper listaReproduccionMapper = new ListaReproduccionMapper();

        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuario.setListasDeReproduccion(listaReproduccionMapper.mapToListasDeReproduccion(usuarioDTO.getListasReproduccionDTO())); // TODO: crear metodo mapToListasReproduccion

        return usuario;
    }

    public static List<UsuarioDTO> mapToListaUsuariosDTO(List<Usuario> listaUsuarios){
        List<UsuarioDTO> listaUsuariosDTO = new ArrayList<>();
        for(Usuario usuario : listaUsuarios){
            listaUsuariosDTO.add(mapToUsuarioDTO(usuario));
        }
        return listaUsuariosDTO;
    }

}

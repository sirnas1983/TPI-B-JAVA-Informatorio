package com.informatorio.java.service.usuario;

import com.informatorio.java.dto.UsuarioDTO;
import com.informatorio.java.mapper.UsuarioMapper;
import com.informatorio.java.model.Usuario;
import com.informatorio.java.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDTO traerPorId(String id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()){
            return usuarioMapper.mapToUsuarioDTO(usuario.get());
        }
        return null;
    }

    @Override
    public List<UsuarioDTO> traerTodos() {
        return usuarioMapper.mapToListaUsuariosDTO(usuarioRepository.findAll());
    }

    @Override
    public void modificar(UsuarioDTO usuarioDTO) {
        usuarioRepository.save(usuarioMapper.mapToUsuario(usuarioDTO));
    }

    @Override
    public void cargar(UsuarioDTO usuarioDTO) {
        usuarioRepository.save(usuarioMapper.mapToUsuario(usuarioDTO));
    }

    @Override
    public void eliminar(UsuarioDTO usuarioDTO) {
        usuarioRepository.delete(usuarioMapper.mapToUsuario(usuarioDTO));
    }
}

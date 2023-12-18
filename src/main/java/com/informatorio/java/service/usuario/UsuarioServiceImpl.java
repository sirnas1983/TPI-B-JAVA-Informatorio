package com.informatorio.java.service.usuario;

import com.informatorio.java.dto.usuario.UsuarioDTO;
import com.informatorio.java.mapper.UsuarioMapper;
import com.informatorio.java.model.Auditor;
import com.informatorio.java.model.Usuario;
import com.informatorio.java.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO traerPorId(String id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(UsuarioMapper::mapToUsuarioDTO).orElse(null);
    }

    @Override
    public List<UsuarioDTO> traerTodos() {
        return UsuarioMapper.mapToListaUsuariosDTO(usuarioRepository.findAll());
    }

    @Override
    public void modificar(UsuarioDTO usuarioDTO) {
        usuarioRepository.save(UsuarioMapper.mapToUsuario(usuarioDTO));
    }

    @Override
    public boolean cargar(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuario.setNombre(usuarioDTO.getNombre());
        Auditor auditor = new Auditor();
        auditor.setFechaRegistro(LocalDate.now());
        auditor.setFechaModificacion(LocalDate.now());
        usuario.setAuditor(auditor);
        usuarioRepository.save(usuario);
        return true;
    }

    @Override
    public void eliminar(UsuarioDTO usuarioDTO) {
        usuarioRepository.delete(UsuarioMapper.mapToUsuario(usuarioDTO));
    }
}

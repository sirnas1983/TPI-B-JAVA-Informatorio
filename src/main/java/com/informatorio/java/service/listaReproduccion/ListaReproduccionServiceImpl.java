package com.informatorio.java.service.listaReproduccion;

import com.informatorio.java.dto.listaReproduccion.ListaReproduccionDTO;
import com.informatorio.java.dto.listaReproduccion.ListaReproduccionUsuarioDTO;
import com.informatorio.java.exceptions.NotFoundException;
import com.informatorio.java.mapper.ListaReproduccionMapper;
import com.informatorio.java.model.Auditor;
import com.informatorio.java.model.Cancion;
import com.informatorio.java.model.ListaReproduccion;
import com.informatorio.java.model.Usuario;
import com.informatorio.java.repository.CancionRepository;
import com.informatorio.java.repository.ListaReproduccionRepository;
import com.informatorio.java.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class ListaReproduccionServiceImpl implements ListaReproduccionService{

    @Autowired
    ListaReproduccionRepository listaReproduccionRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    CancionRepository cancionRepository;


    @Override
    public ListaReproduccionDTO traerPorId(String id) {
        Optional<ListaReproduccion> listaReproduccion = listaReproduccionRepository.findById(id);
        if (listaReproduccion.isPresent()){
            return ListaReproduccionMapper.mapToListaReproduccionDTO(listaReproduccion.get());
        } else {
            throw new NotFoundException("Lista Reproduccion", "Id Lista reproduccion", id);
        }
    }

    @Override
    public List<ListaReproduccionUsuarioDTO> buscarPorNombre(String nombre) {
        return ListaReproduccionMapper.mapToListasDeReproduccionUsuarioDTO(listaReproduccionRepository.buscarPorNombre(nombre));
    }

    @Override
    public List<ListaReproduccionUsuarioDTO> traerListasUsuario(String usuarioId) {
        return ListaReproduccionMapper.mapToListasDeReproduccionUsuarioDTO(listaReproduccionRepository.buscarListasPorUsuario(usuarioId));
    }

    @Override
    public boolean modificarListaReproduccion(String id, Boolean aleatorio, Boolean publica, Boolean repetir, List<String> listaIdCanciones) {

        Optional<ListaReproduccion> listaReproduccion = listaReproduccionRepository.findById(id);
        if (listaReproduccion.isPresent()){
            if(!isNull(listaIdCanciones)){
                for (String idCancion : listaIdCanciones) {
                    Optional<Cancion> cancion = cancionRepository.findById(idCancion);
                    if (cancion.isPresent()) {
                        List<Cancion> listaCanciones = listaReproduccion.get().getCanciones();
                        boolean presente = listaCanciones.stream().anyMatch(canc -> canc.getId().equals(idCancion));
                        if (!presente) {
                            listaCanciones.add(cancion.get());
                        } else {
                            listaCanciones.remove(cancion.get());
                        }
                    } else {
                        throw new NotFoundException("Cancion", "Id Cancion", idCancion);
                    }
                }
            }
            if(!isNull(aleatorio)){
                listaReproduccion.get().setAleatorio(aleatorio);
            }
            if(!isNull(publica)){
                listaReproduccion.get().setPublica(publica);
            }
            if(!isNull(repetir)){
                listaReproduccion.get().setRepetir(repetir);
            }
            if(!isNull(aleatorio) || !isNull(publica) || !isNull(repetir)){
                listaReproduccion.get().getAuditor().setFechaModificacion(LocalDate.now());
            }
            listaReproduccionRepository.save(listaReproduccion.get());
            return true;
        } else {
            throw new NotFoundException("Lista Reproduccion", "Id Lista reproduccion", id);
        }
    }

    @Override
    public boolean nuevaLista(String nombre, List<String> listaIdCanciones, String idUsuario) {

        Optional<Usuario> usuario =  usuarioRepository.findById(idUsuario);
        if(usuario.isPresent()){
            ListaReproduccion listaReproduccion = new ListaReproduccion();
            listaReproduccion.setCanciones(cancionRepository.findAllById(listaIdCanciones));
            listaReproduccion.setUsuario(usuario.get());
            listaReproduccion.setNombre(nombre);
            listaReproduccion.setPublica(false);
            listaReproduccion.setAleatorio(false);
            listaReproduccion.setRepetir(false);
            Auditor auditor = new Auditor();
            auditor.setFechaRegistro(LocalDate.now());
            auditor.setFechaModificacion(LocalDate.now());
            listaReproduccion.setAuditor(auditor);
            listaReproduccionRepository.save(listaReproduccion);
            return true;
        } else {
            throw new NotFoundException("Usuario", "Id Usuario", idUsuario);
        }
    }

}

package com.informatorio.java.service.listaReproduccion;

import com.informatorio.java.dto.listaReproduccion.ListaReproduccionDTO;
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
    ListaReproduccionMapper listaReproduccionMapper;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    CancionRepository cancionRepository;


    @Override
    public ListaReproduccionDTO traerPorId(String id) {
        Optional<ListaReproduccion> listaReproduccion = listaReproduccionRepository.findById(id);
        return listaReproduccion.map(reproduccion -> listaReproduccionMapper.mapToListaDeReproduccionDTO(reproduccion)).orElse(null);
    }

    @Override
    public List<ListaReproduccionDTO> traerTodos() {
        return listaReproduccionMapper.mapToListasDeReproduccionDTO(listaReproduccionRepository.findAll());
    }

    @Override
    public void modificar(ListaReproduccionDTO listaReproduccionDTO){
        listaReproduccionRepository.save(listaReproduccionMapper.mapToListaDeReproduccion(listaReproduccionDTO));
    }

    @Override
    public void cargar(ListaReproduccionDTO listaReproduccionDTO) {
        listaReproduccionRepository.save(listaReproduccionMapper.mapToListaDeReproduccion(listaReproduccionDTO));
    }

    @Override
    public void eliminar(ListaReproduccionDTO listaReproduccionDTO) {
        listaReproduccionRepository.delete(listaReproduccionMapper.mapToListaDeReproduccion(listaReproduccionDTO));
    }

    @Override
    public List<ListaReproduccionDTO> traerListasUsuario(String usuarioId) {

        Optional<Usuario> usuario =  usuarioRepository.findById(usuarioId);
        return usuario.map(value -> listaReproduccionMapper.mapToListasDeReproduccionDTO(value.getListasDeReproduccion())).orElse(null);

    }

    @Override
    public void modificarEstadoListaReproduccion(String id, Boolean aleatorio, Boolean publica, Boolean repetir) {

        Optional<ListaReproduccion> listaReproduccion = listaReproduccionRepository.findById(id);
        if (listaReproduccion.isPresent()){
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
        }
    }

    @Override
    public void nuevaLista(String nombre, List<String> listaIdCanciones, String idUsuario) {

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
        }
    }

    @Override
    public void modificarListaReproduccion(String idListaReproduccion, String idCancion) {

        Optional<ListaReproduccion> listaReproduccion = listaReproduccionRepository.findById(idListaReproduccion);
        Optional<Cancion> cancion = cancionRepository.findById(idCancion);
        if(listaReproduccion.isPresent() && cancion.isPresent()){
            List<Cancion> listaCanciones = listaReproduccion.get().getCanciones();
            listaCanciones = listaCanciones.stream().filter(canc -> Objects.equals(canc.getId(), idCancion)).toList();
            if( listaCanciones.isEmpty()){
                listaCanciones.add(cancion.get());
            } else {
                listaCanciones.remove(cancion.get());
            }
            listaReproduccionRepository.save(listaReproduccion.get());
        }
    }

}

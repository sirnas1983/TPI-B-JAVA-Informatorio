package com.informatorio.java.service.cancion;

import com.informatorio.java.dto.CancionDTO;
import com.informatorio.java.dto.GeneroDTO;
import com.informatorio.java.mapper.ArtistaMapper;
import com.informatorio.java.mapper.CancionMapper;
import com.informatorio.java.mapper.GeneroMapper;
import com.informatorio.java.model.Artista;
import com.informatorio.java.model.Cancion;
import com.informatorio.java.model.Genero;
import com.informatorio.java.repository.ArtistaRepository;
import com.informatorio.java.repository.CancionRepository;
import com.informatorio.java.repository.GeneroRepository;
import com.informatorio.java.service.artista.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;


@Service
public class CancionServiceImpl implements CancionService{

    @Autowired
    CancionRepository cancionRepository;
    @Autowired
    CancionMapper cancionMapper;
    @Autowired
    ArtistaService artistaService;
    @Autowired
    ArtistaMapper artistaMapper;
    @Autowired
    GeneroRepository generoRepository;
    @Autowired
    GeneroMapper generoMapper;

    @Override
    public CancionDTO traerPorId(String id) {
        Optional<Cancion> cancion = cancionRepository.findById(id);
        if (cancion.isPresent()){
            return cancionMapper.mapToCancionDTO(cancion.get());
        }
        return null ;
    }

    @Override
    public List<CancionDTO> traerTodos() {
        return cancionMapper.mapToListaCancionesDTO(cancionRepository.findAll());
    }

    @Override
    public void modificar(CancionDTO cancionDTO) {
        cancionRepository.save(cancionMapper.mapToCancion(cancionDTO));
    }

    @Override
    public void cargar(CancionDTO cancionDTO) {
        Cancion cancion = new Cancion();
        Optional<Artista> artista = artistaService.buscarPorNombre(cancionDTO.getArtistaDTO().getNombre());
        if(artista.isPresent()){
            cancion.setArtista(artista.get());
        } else {
            cancion.setArtista(artistaMapper.mapToArtista(cancionDTO.getArtistaDTO()));
        }
        List<Genero> listaGeneros = new ArrayList<>();
        for (GeneroDTO genero : cancionDTO.getGenerosDTO()){
            if(!isNull(generoRepository.findByNombre(genero.getNombre().toLowerCase()))){
                listaGeneros.add(generoRepository.findByNombre(genero.getNombre().toLowerCase()));
            } else {
                listaGeneros.add(new Genero(genero.getNombre().toLowerCase()));
            }
        }
        cancion.setGeneros(listaGeneros);
        cancion.setNombre(cancionDTO.getNombre());
        cancion.setRanking(cancionDTO.getRanking());
        cancion.setDuracion(cancionDTO.getDuracion());
        cancion.setAlbum(cancionDTO.getAlbum());
        cancionRepository.save(cancion);
    }

    @Override
    public void eliminar(CancionDTO cancionDTO) {
        cancionRepository.delete(cancionMapper.mapToCancion(cancionDTO));
    }

    @Override
    public List<Cancion> traerCancionesPorId(List<String> listaIdCanciones) {
        return cancionRepository.findAllById(listaIdCanciones);
    }
}

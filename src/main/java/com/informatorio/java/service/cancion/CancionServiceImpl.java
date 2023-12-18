package com.informatorio.java.service.cancion;

import com.informatorio.java.dto.cancion.CancionDTO;
import com.informatorio.java.dto.genero.GeneroDTO;
import com.informatorio.java.exceptions.NotFoundException;
import com.informatorio.java.mapper.ArtistaMapper;
import com.informatorio.java.mapper.CancionMapper;
import com.informatorio.java.model.Artista;
import com.informatorio.java.model.Cancion;
import com.informatorio.java.model.Genero;
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
    ArtistaService artistaService;
    @Autowired
    GeneroRepository generoRepository;

    @Override
    public CancionDTO traerPorId(String id) {
        Optional<Cancion> cancion = cancionRepository.findById(id);
        if (cancion.isPresent()){
            return CancionMapper.mapToCancionDTO(cancion.get());
        } else {
            throw new NotFoundException("Cancion", "Cancion ID", id);
        }

    }

    @Override
    public List<CancionDTO> traerTodos() {
        return CancionMapper.mapToListaCancionesDTO(cancionRepository.findAll());
    }

    @Override
    public void modificar(CancionDTO cancionDTO) {
        cancionRepository.save(CancionMapper.mapToCancion(cancionDTO));
    }

    @Override
    public boolean cargar(CancionDTO cancionDTO) {
        Cancion cancion = new Cancion();
        Optional<Artista> artista = artistaService.buscarPorNombre(cancionDTO.getArtistaDTO().getNombre());
        if(artista.isPresent()){
            cancion.setArtista(artista.get());
        } else {
            cancion.setArtista(ArtistaMapper.mapToArtista(cancionDTO.getArtistaDTO()));
        }
        List<Genero> listaGeneros = new ArrayList<>();
        for (GeneroDTO genero : cancionDTO.getGenerosDTO()){
            Genero gen = generoRepository.findByNombre(genero.getNombre().toUpperCase());
            if(!isNull(gen)){
                listaGeneros.add(gen);
            } else {
                listaGeneros.add(new Genero(genero.getNombre().toUpperCase()));
            }
        }
        cancion.setGeneros(listaGeneros);
        cancion.setNombre(cancionDTO.getNombre());
        cancion.setRanking(cancionDTO.getRanking());
        cancion.setDuracion(cancionDTO.getDuracion());
        cancion.setAlbum(cancionDTO.getAlbum());
        cancionRepository.save(cancion);
        return true;
    }

    @Override
    public void eliminar(CancionDTO cancionDTO) {
        cancionRepository.delete(CancionMapper.mapToCancion(cancionDTO));
    }

    @Override
    public List<Cancion> traerCancionesPorId(List<String> listaIdCanciones) {
        return cancionRepository.findAllById(listaIdCanciones);
    }

    //SI
    @Override
    public List<CancionDTO> buscarPorGeneroArtistaTituloAlbum(String gen, String artista, String titulo, String album) {
        if (isNull(gen)) {
            return CancionMapper.mapToListaCancionesDTO(cancionRepository.findByGeneroArtistaTituloAlbum(null, artista, titulo, album));
        } else  {
            Genero genero = generoRepository.findByNombre(gen.toUpperCase());
            if (isNull(genero)){
                throw new NotFoundException("Genero", "nombre", gen);
            } else {
                return CancionMapper.mapToListaCancionesDTO(cancionRepository.findByGeneroArtistaTituloAlbum(genero, artista, titulo, album));
            }
        }
    }
}

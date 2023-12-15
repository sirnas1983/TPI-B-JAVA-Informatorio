package com.informatorio.java.service.artista;

import com.informatorio.java.dto.ArtistaDTO;
import com.informatorio.java.mapper.ArtistaMapper;
import com.informatorio.java.model.Artista;
import com.informatorio.java.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ArtistaServiceImpl implements ArtistaService{

    @Autowired
    ArtistaRepository artistaRepository;
    @Autowired
    ArtistaMapper artistaMapper;

    @Override
    public ArtistaDTO traerPorId(String id) {
        Optional<Artista> artista = artistaRepository.findById(id);
        if (artista.isPresent()) {
            return artistaMapper.mapToArtistaDTO(artista.get());
        }
        return null;
    }

    @Override
    public List<ArtistaDTO> traerTodos() {
        return artistaMapper.mapToListaArtistasDTO(artistaRepository.findAll());
    }

    @Override
    public void modificar(ArtistaDTO artistaDTO) {

        artistaRepository.save(artistaMapper.mapToArtista(artistaDTO));
    }

    @Override
    public void crear(ArtistaDTO artistaDTO) {
        artistaRepository.save(artistaMapper.mapToArtista(artistaDTO));
    }

    @Override
    public void eliminar(ArtistaDTO artistaDTO) {
        artistaRepository.delete(artistaMapper.mapToArtista(artistaDTO));
    }

    @Override
    public Optional<Artista> buscarPorNombre(String nombre) {
        return Optional.ofNullable(artistaRepository.getArtistaPorNombre(nombre));
    }

}

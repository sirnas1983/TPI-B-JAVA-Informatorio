package com.informatorio.java.service.artista;

import com.informatorio.java.dto.artista.ArtistaDTO;
import com.informatorio.java.exceptions.NotFoundException;
import com.informatorio.java.mapper.ArtistaMapper;
import com.informatorio.java.model.Artista;
import com.informatorio.java.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ArtistaServiceImpl implements ArtistaService{

    @Autowired
    ArtistaRepository artistaRepository;


    @Override
    public ArtistaDTO traerPorId(String id) {
        Optional<Artista> artista = artistaRepository.findById(id);
        if (artista.isPresent()) {
            return ArtistaMapper.mapToArtistaDTO(artista.get());
        }
        throw new NotFoundException("Artista", "Artista ID", id);
    }

    @Override
    public void crear(ArtistaDTO artistaDTO) {
        artistaRepository.save(ArtistaMapper.mapToArtista(artistaDTO));
    }


    @Override
    public Optional<Artista> buscarPorNombre(String nombre) {
        return Optional.ofNullable(artistaRepository.getArtistaPorNombre(nombre));
    }

}

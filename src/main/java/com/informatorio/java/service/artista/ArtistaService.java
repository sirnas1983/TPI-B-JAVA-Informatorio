package com.informatorio.java.service.artista;

import com.informatorio.java.dto.artista.ArtistaDTO;
import com.informatorio.java.model.Artista;

import java.util.Optional;

public interface ArtistaService {
    ArtistaDTO traerPorId(String id);
    void crear(ArtistaDTO artistaDTO);
    Optional<Artista> buscarPorNombre(String nombre);

}

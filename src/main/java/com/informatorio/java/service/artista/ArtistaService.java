package com.informatorio.java.service.artista;

import com.informatorio.java.dto.ArtistaDTO;
import com.informatorio.java.model.Artista;

import java.util.List;
import java.util.Optional;

public interface ArtistaService {
    ArtistaDTO traerPorId(String id);
    List<ArtistaDTO> traerTodos();
    void modificar(ArtistaDTO artistaDTO);
    void crear(ArtistaDTO artistaDTO);
    void eliminar(ArtistaDTO artistaDTO);

    Optional<Artista> buscarPorNombre(String nombre);

}

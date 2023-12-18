package com.informatorio.java.service.cancion;

import com.informatorio.java.dto.cancion.CancionDTO;
import com.informatorio.java.model.Cancion;

import java.util.List;

public interface CancionService {

    CancionDTO traerPorId(String id);
    List<CancionDTO> traerTodos();
    void modificar(CancionDTO cancionDTO);
    boolean cargar(CancionDTO cancionDTO);
    void eliminar(CancionDTO cancionDTO);
    List<Cancion> traerCancionesPorId(List<String> listaIdCanciones);
    List<CancionDTO> buscarPorGeneroArtistaTituloAlbum(String gen, String artista, String titulo, String album);
}

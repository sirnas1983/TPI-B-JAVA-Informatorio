package com.informatorio.java.service.cancion;

import com.informatorio.java.dto.CancionDTO;
import com.informatorio.java.model.Cancion;

import java.util.List;
import java.util.Optional;

public interface CancionService {

    CancionDTO traerPorId(String id);
    List<CancionDTO> traerTodos();
    void modificar(CancionDTO cancionDTO);
    void cargar(CancionDTO cancionDTO);
    void eliminar(CancionDTO cancionDTO);

    List<Cancion> traerCancionesPorId(List<String> listaIdCanciones);
}

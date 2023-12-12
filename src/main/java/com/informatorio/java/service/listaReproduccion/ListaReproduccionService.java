package com.informatorio.java.service.listaReproduccion;

import com.informatorio.java.dto.ListaReproduccionDTO;
import com.informatorio.java.model.ListaReproduccion;
import java.util.List;
import java.util.Optional;

public interface ListaReproduccionService {

    ListaReproduccionDTO traerPorId(String id);
    List<ListaReproduccionDTO> traerTodos();
    void modificar(ListaReproduccionDTO listaReproduccionDTO);
    void cargar(ListaReproduccionDTO listaReproduccionDTO);
    void eliminar(ListaReproduccionDTO listaReproduccionDTO);
}
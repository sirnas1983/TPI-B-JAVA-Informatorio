package com.informatorio.java.service.listaReproduccion;

import com.informatorio.java.dto.listaReproduccion.ListaReproduccionDTO;

import java.util.List;

public interface ListaReproduccionService {

    ListaReproduccionDTO traerPorId(String id);
    List<ListaReproduccionDTO> traerTodos();
    void modificar(ListaReproduccionDTO listaReproduccionDTO);
    void cargar(ListaReproduccionDTO listaReproduccionDTO);
    void eliminar(ListaReproduccionDTO listaReproduccionDTO);
    List<ListaReproduccionDTO> traerListasUsuario(String usuarioId);
    void modificarEstadoListaReproduccion(String id, Boolean isAleatorio, Boolean isRepetir, Boolean isPublica);
    void nuevaLista(String nombre, List<String> listaIdCanciones, String idUsuario);
    void modificarListaReproduccion(String idListaReproduccion, String idCancion);
}

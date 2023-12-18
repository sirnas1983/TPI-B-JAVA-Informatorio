package com.informatorio.java.service.listaReproduccion;

import com.informatorio.java.dto.listaReproduccion.ListaReproduccionDTO;
import com.informatorio.java.dto.listaReproduccion.ListaReproduccionUsuarioDTO;

import java.util.List;

public interface ListaReproduccionService {

    ListaReproduccionDTO traerPorId(String id);
    List<ListaReproduccionUsuarioDTO> buscarPorNombre(String nombre);
    List<ListaReproduccionUsuarioDTO> traerListasUsuario(String usuarioId);
    boolean modificarListaReproduccion(String id, Boolean isAleatorio, Boolean isRepetir, Boolean isPublica, List<String> listaIdCanciones);
    boolean nuevaLista(String nombre, List<String> listaIdCanciones, String idUsuario);
}

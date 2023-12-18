package com.informatorio.java.service.genero;

import com.informatorio.java.dto.genero.GeneroDTO;

import java.util.List;

public interface GeneroService {
    GeneroDTO traerPorId(String id);
    List<GeneroDTO> traerTodos();
    void cargar(GeneroDTO generoDTO);

}

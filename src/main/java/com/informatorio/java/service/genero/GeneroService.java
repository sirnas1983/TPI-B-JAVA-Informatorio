package com.informatorio.java.service.genero;

import com.informatorio.java.dto.GeneroDTO;
import com.informatorio.java.model.Genero;
import java.util.List;
import java.util.Optional;

public interface GeneroService {
    GeneroDTO traerPorId(String id);
    List<GeneroDTO> traerTodos();
    void modificar(GeneroDTO generoDTO);
    void cargar(GeneroDTO generoDTO);
    void eliminar(GeneroDTO generoDTO);
}

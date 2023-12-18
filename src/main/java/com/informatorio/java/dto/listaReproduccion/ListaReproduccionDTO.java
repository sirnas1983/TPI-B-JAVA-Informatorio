package com.informatorio.java.dto.listaReproduccion;

import com.informatorio.java.dto.cancion.CancionDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter @Setter
public class ListaReproduccionDTO {

    private String id;
    private String nombre;
    private List<CancionDTO> listaCancionesDTO;

}

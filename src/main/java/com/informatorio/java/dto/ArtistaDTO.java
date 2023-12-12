package com.informatorio.java.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ArtistaDTO {

    private String id;
    private String nombre;
    private List<CancionDTO> cancionesDTO;
}

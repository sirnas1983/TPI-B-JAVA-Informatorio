package com.informatorio.java.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CancionDTO {

    private String id;
    private String nombre;
    private int ranking;
    private float duracion;
    private ArtistaDTO artistaDTO;
    private String album;
    private List<GeneroDTO> generosDTO = new ArrayList<>();


}

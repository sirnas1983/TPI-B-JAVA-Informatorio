package com.informatorio.java.dto.listaReproduccion;

import com.informatorio.java.dto.CancionDTO;
import com.informatorio.java.model.Auditor;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class ListaReproduccionDTO {

    private String id;
    private String nombre;

    private List<CancionDTO> canciones = new ArrayList<>();
    private int cantCanciones = this.canciones.size();




}

package com.informatorio.java.dto.listaReproduccion;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Setter
@Getter
public class ListaReproduccionUsuarioDTO {

    private String id;
    private String nombre;
    private int cantCanciones;

}

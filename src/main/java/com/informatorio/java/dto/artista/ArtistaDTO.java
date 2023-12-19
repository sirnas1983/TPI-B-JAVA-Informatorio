package com.informatorio.java.dto.artista;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ArtistaDTO {


    private String id;
    @NotBlank(message = "Campo 'nombre' no puede ser nulo o vacio")
    private String nombre;

}

package com.informatorio.java.dto.cancion;

import com.informatorio.java.dto.genero.GeneroDTO;
import com.informatorio.java.dto.artista.ArtistaDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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
    @NotBlank(message = "Nombre no puede ser nulo o vacio")
    private String nombre;
    @NotNull(message = "Ranking no puede ser nulo o vacio")
    @PositiveOrZero(message = "Ranking debe ser mayor o igual a 0")
    @Max(value = 10)
    private int ranking;
    @NotNull(message = "Duracion no puede ser nulo o vacio")
    @Positive(message = "Duracion debe ser mayor a 0")
    private float duracion;
    @Valid
    private ArtistaDTO artistaDTO;
    @NotBlank(message = "Album no puede ser nulo o vacio")
    private String album;
    @Valid
    private List<GeneroDTO> generosDTO = new ArrayList<>();


}

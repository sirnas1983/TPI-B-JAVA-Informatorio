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
    @NotBlank(message = "Campo 'nombre' no puede ser nulo o vacio")
    private String nombre;
    @NotNull(message = "Campo 'ranking' no puede ser nulo")
    @PositiveOrZero(message = "Campo 'ranking' debe ser mayor o igual a 0")
    @Max(value = 10)
    private int ranking;
    @NotNull(message = "Campo 'duracion' no puede ser nulo")
    @Positive(message = "Campo 'duracion' debe ser mayor a 0")
    private float duracion;
    @Valid
    @NotNull(message = "Campo 'artista' no puede estar vacio")
    private ArtistaDTO artistaDTO;
    @NotBlank(message = "Campo 'album' no puede ser nulo o vacio")
    private String album;
    @Valid
    private List<GeneroDTO> generosDTO = new ArrayList<>();
}

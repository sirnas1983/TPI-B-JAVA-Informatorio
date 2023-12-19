package com.informatorio.java.dto.listaReproduccion;

import com.informatorio.java.dto.cancion.CancionDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter @Setter
public class ListaReproduccionDTO {

    private String id;
    @NotBlank(message = "Campo 'nombre' no puede ser nulo o vacio")
    private String nombre;
    @Valid
    private List<CancionDTO> listaCancionesDTO;

}

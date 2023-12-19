package com.informatorio.java.dto.genero;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GeneroDTO {

    private String id;
    @NotBlank(message = "Campo 'nombre' no puede ser nulo o vacio")
    private String nombre;

}

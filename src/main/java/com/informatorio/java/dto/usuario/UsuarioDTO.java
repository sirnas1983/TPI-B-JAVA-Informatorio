package com.informatorio.java.dto.usuario;

import com.informatorio.java.dto.listaReproduccion.ListaReproduccionUsuarioDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter @Setter
public class UsuarioDTO {

    private String id;
    @NotBlank(message = "Nombre no puede ser nulo o vacio")
    private String nombre;
    @NotBlank(message = "Nombre de usuario no puede ser nulo o vacio")
    private String nombreUsuario;
    private List<ListaReproduccionUsuarioDTO> listasReproduccionDTO;
}

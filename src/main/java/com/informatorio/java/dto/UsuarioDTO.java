package com.informatorio.java.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@NoArgsConstructor
@Getter @Setter
public class UsuarioDTO {

    private String id;
    private String nombre;
    private String nombreUsuario;
    private List<ListaReproduccionDTO> listasReproduccionDTO;
}

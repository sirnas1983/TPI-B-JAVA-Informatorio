package com.informatorio.java.dto.usuario;

import com.informatorio.java.dto.listaReproduccion.ListaReproduccionUsuarioDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter @Setter
public class UsuarioDTO {

    private String id;
    private String nombre;
    private String nombreUsuario;
    private List<ListaReproduccionUsuarioDTO> listasReproduccionDTO;
}

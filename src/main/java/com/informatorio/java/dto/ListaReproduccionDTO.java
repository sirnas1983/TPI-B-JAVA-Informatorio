package com.informatorio.java.dto;

import com.informatorio.java.model.Auditor;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class ListaReproduccionDTO {

    private String id;
    private String nombre;
    private UsuarioDTO usuario;
    private boolean aleatorio;
    private boolean repetir;
    private boolean publica;
    private Auditor auditor;
    private List<CancionDTO> canciones;




}

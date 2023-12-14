package com.informatorio.java.dto;

import com.informatorio.java.model.Auditor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class ListaReproduccionStatusDTO {

    private String id;

    private boolean aleatorio;
    private boolean repetir;
    private boolean publica;
    private Auditor auditor;





}

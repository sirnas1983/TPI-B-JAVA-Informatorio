package com.informatorio.java.model;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Usuario extends EntidadMusical{

    private String nombreUsuario;

    @OneToOne(cascade =CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "auditor_id")
    private Auditor auditor;

    @OneToMany(mappedBy = "usuario",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<ListaReproduccion> listasDeReproduccion = new ArrayList<>();

}

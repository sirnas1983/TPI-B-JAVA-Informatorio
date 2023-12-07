package com.informatorio.java.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Usuario extends EntidadMusical{

    private String nombreUsuario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditor_id")
    private Auditor auditor;

    @OneToMany(mappedBy = "usuario")
    private List<ListaReproduccion> listasDeReproduccion;

}

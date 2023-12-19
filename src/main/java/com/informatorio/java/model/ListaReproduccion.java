package com.informatorio.java.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ListaReproduccion extends EntidadMusical{

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(name = "cancion_lista_reproduccion",
            joinColumns = {@JoinColumn(name = "cancion_id")},
            inverseJoinColumns = {@JoinColumn(name = "listareproduccion_id")})
    private List<Cancion> canciones = new ArrayList<>();

    private Boolean aleatorio;

    private Boolean repetir;

    private Boolean publica;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "id_auditor")
    private Auditor auditor;

}

package com.informatorio.java.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ListaReproduccion extends EntidadMusical{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
            },fetch = FetchType.LAZY)
    @JoinTable(name = "cancion_lista_reproduccion",
            joinColumns = {@JoinColumn(name = "cancion_id")},
            inverseJoinColumns = {@JoinColumn(name = "listareproduccion_id")})
    private List<Cancion> canciones;

    private Boolean aleatorio;

    private Boolean repetir;

    private Boolean publica;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_auditor")
    private Auditor auditor;

}

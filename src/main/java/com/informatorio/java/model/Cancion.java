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
@Getter
@Setter
public class Cancion extends EntidadMusical{

    private int ranking;

    private float duracion;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(
            name = "genero_cancion",
            joinColumns = {@JoinColumn(name = "genero_id")},
            inverseJoinColumns = {@JoinColumn(name = "cancion_id")}    )
    private List<Genero> generos = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artista_id")
    private Artista artista;

    private String album;
}

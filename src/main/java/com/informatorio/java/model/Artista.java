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
public class Artista extends EntidadMusical{

    @OneToMany(mappedBy ="artista",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Cancion> canciones = new ArrayList<>();

}

package com.informatorio.java.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Genero extends EntidadMusical{

    public Genero(String nombre){
        this.nombre = nombre;
    }

    @ManyToMany(mappedBy = "generos",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Cancion> canciones = new ArrayList<>();


}

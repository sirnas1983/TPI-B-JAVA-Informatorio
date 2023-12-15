package com.informatorio.java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
public class Genero extends EntidadMusical{

    public Genero(String nombre){
        this.nombre = nombre;
    }

    @ManyToMany(mappedBy = "generos")
    private List<Cancion> canciones = new ArrayList<>();


}

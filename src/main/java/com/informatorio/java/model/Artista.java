package com.informatorio.java.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
            cascade = CascadeType.ALL)
    private List<Cancion> canciones = new ArrayList<>();

}

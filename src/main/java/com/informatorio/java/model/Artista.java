package com.informatorio.java.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Artista extends EntidadMusical{

    @OneToMany(mappedBy ="artista",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Cancion> canciones;

}

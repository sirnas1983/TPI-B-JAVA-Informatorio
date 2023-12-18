package com.informatorio.java.repository;

import com.informatorio.java.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, String> {

    @Query("SELECT a FROM Artista a WHERE a.nombre = ?1")
    Artista getArtistaPorNombre(String nombre);



}

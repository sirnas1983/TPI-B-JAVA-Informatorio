package com.informatorio.java.repository;

import com.informatorio.java.model.Cancion;
import com.informatorio.java.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, String> {
   @Query("FROM Cancion c " +
           "WHERE (?1 is null OR ?1 IN ELEMENTS(c.generos)) " +
           "AND (?2 is null OR UPPER(c.artista.nombre) = UPPER(?2)) " +
           "AND (?3 is null OR UPPER(c.nombre) = UPPER(?3)) " +
           "AND (?4 is null OR UPPER(c.album) = UPPER(?4)) " +
           "ORDER BY c.ranking")
   List<Cancion> findByGeneroArtistaTituloAlbum(Genero genero, String artista, String titulo, String album);

}

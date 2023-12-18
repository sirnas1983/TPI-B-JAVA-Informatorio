package com.informatorio.java.repository;

import com.informatorio.java.model.ListaReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaReproduccionRepository extends JpaRepository<ListaReproduccion, String> {


@Query("FROM ListaReproduccion l " +
        "WHERE (?1 is null OR l.nombre LIKE ?1) " +
        "AND l.publica = true")
    List<ListaReproduccion> buscarPorNombre(String nombre);

@Query("FROM ListaReproduccion l " +
        "WHERE (?1 is null OR l.usuario.id LIKE ?1) " +
        "ORDER BY l.auditor.fechaRegistro DESC")
List<ListaReproduccion> buscarListasPorUsuario(String id);


}

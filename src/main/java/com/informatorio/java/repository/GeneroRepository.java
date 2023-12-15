package com.informatorio.java.repository;

import com.informatorio.java.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, String> {

    @Query("SELECT g FROM Genero g WHERE g.nombre = ?1")
    Genero findByNombre(String nombre);
}

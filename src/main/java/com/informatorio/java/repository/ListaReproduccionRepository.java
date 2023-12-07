package com.informatorio.java.repository;

import com.informatorio.java.model.ListaReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaReproduccionRepository extends JpaRepository<ListaReproduccion, String> {
}

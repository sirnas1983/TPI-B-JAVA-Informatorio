package com.informatorio.java.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class EntidadMusical {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected String id;

    @Column
    protected String nombre;



}

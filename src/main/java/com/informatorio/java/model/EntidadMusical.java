package com.informatorio.java.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
public abstract class EntidadMusical {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected String id;

    @Column
    protected String nombre;



}

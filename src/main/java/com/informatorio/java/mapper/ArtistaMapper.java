package com.informatorio.java.mapper;

import com.informatorio.java.dto.ArtistaDTO;
import com.informatorio.java.model.Artista;

public class ArtistaMapper {

    public Artista mapToArtista(ArtistaDTO artistaDTO){

        CancionMapper cancionMapper = new CancionMapper();

        Artista artista = new Artista();
        artista.setId(artistaDTO.getId());
        artista.setNombre(artistaDTO.getNombre());
        artista.setCanciones(cancionMapper.mapToListaCanciones(artistaDTO.getCancionesDTO()));

        return artista;
    }

    public ArtistaDTO mapToArtistaDTO(Artista artista){

        CancionMapper cancionMapper = new CancionMapper();

        ArtistaDTO artistaDTO = new ArtistaDTO();
        artistaDTO.setId(artista.getId());
        artistaDTO.setNombre(artista.getNombre());
        artistaDTO.setCancionesDTO(cancionMapper.mapToListaCancionesDTO(artista.getCanciones()));

        return artistaDTO;
    }


}

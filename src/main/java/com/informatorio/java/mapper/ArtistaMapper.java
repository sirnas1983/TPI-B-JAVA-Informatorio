package com.informatorio.java.mapper;

import com.informatorio.java.dto.ArtistaDTO;
import com.informatorio.java.model.Artista;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ArtistaMapper {

    public Artista mapToArtista(ArtistaDTO artistaDTO){

        CancionMapper cancionMapper = new CancionMapper();

        Artista artista = new Artista();
        artista.setId(artistaDTO.getId());
        artista.setNombre(artistaDTO.getNombre());

        return artista;
    }

    public ArtistaDTO mapToArtistaDTO(Artista artista){

        CancionMapper cancionMapper = new CancionMapper();

        ArtistaDTO artistaDTO = new ArtistaDTO();
        artistaDTO.setId(artista.getId());
        artistaDTO.setNombre(artista.getNombre());

        return artistaDTO;
    }

    public List<ArtistaDTO> mapToListaArtistasDTO(List<Artista> listaArtistas){
        List<ArtistaDTO> listaArtistasDTO = new ArrayList<>();
        for (Artista artista : listaArtistas){
            listaArtistasDTO.add(mapToArtistaDTO(artista));
        }
        return listaArtistasDTO;
    }


}

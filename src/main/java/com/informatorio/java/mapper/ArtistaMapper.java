package com.informatorio.java.mapper;

import com.informatorio.java.dto.artista.ArtistaDTO;
import com.informatorio.java.model.Artista;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ArtistaMapper {

    public static Artista mapToArtista(ArtistaDTO artistaDTO){

        CancionMapper cancionMapper = new CancionMapper();

        Artista artista = new Artista();
        artista.setId(artistaDTO.getId());
        artista.setNombre(artistaDTO.getNombre());

        return artista;
    }

    public static ArtistaDTO mapToArtistaDTO(Artista artista){

        ArtistaDTO artistaDTO = new ArtistaDTO();
        artistaDTO.setId(artista.getId());
        artistaDTO.setNombre(artista.getNombre());

        return artistaDTO;
    }

    public static List<ArtistaDTO> mapToListaArtistasDTO(List<Artista> listaArtistas){
        List<ArtistaDTO> listaArtistasDTO = new ArrayList<>();
        for (Artista artista : listaArtistas){
            listaArtistasDTO.add(mapToArtistaDTO(artista));
        }
        return listaArtistasDTO;
    }


}

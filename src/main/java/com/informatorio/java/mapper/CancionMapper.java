package com.informatorio.java.mapper;

import com.informatorio.java.dto.cancion.CancionDTO;
import com.informatorio.java.model.Cancion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CancionMapper {


    public static CancionDTO mapToCancionDTO(Cancion cancion){

        ArtistaMapper artistaMapper = new ArtistaMapper();
        GeneroMapper generoMapper = new GeneroMapper();

        CancionDTO cancionDTO = new CancionDTO();
        cancionDTO.setId(cancion.getId());
        cancionDTO.setNombre(cancion.getNombre());
        cancionDTO.setRanking(cancion.getRanking());
        cancionDTO.setDuracion(cancion.getDuracion());
        cancionDTO.setAlbum(cancion.getAlbum());
        cancionDTO.setArtistaDTO(artistaMapper.mapToArtistaDTO(cancion.getArtista()));
        cancionDTO.setGenerosDTO(generoMapper.mapToListaGenerosDTO(cancion.getGeneros()));

        return cancionDTO;
    }

    public static Cancion mapToCancion(CancionDTO cancionDTO){

        Cancion cancion = new Cancion();
        ArtistaMapper artistaMapper = new ArtistaMapper();
        GeneroMapper generoMapper = new GeneroMapper();

        cancion.setId(cancionDTO.getId());
        cancion.setId(cancionDTO.getId());
        cancion.setNombre(cancionDTO.getNombre());
        cancion.setRanking(cancionDTO.getRanking());
        cancion.setDuracion(cancionDTO.getDuracion());
        cancion.setArtista(artistaMapper.mapToArtista(cancionDTO.getArtistaDTO()));
        cancion.setGeneros(generoMapper.mapToListaGeneros(cancionDTO.getGenerosDTO()));

        return cancion;
    }

    public static List<Cancion> mapToListaCanciones(List<CancionDTO> listaCancionesDTO){
        List<Cancion> listaCanciones = new ArrayList<>();
        for (CancionDTO cancionDTO : listaCancionesDTO){
            listaCanciones.add(mapToCancion(cancionDTO));
        }
        return listaCanciones;
    }

    public static List<CancionDTO> mapToListaCancionesDTO(List<Cancion> listaCanciones){
        List<CancionDTO> listaCancionesDTO = new ArrayList<>();
        for (Cancion cancion: listaCanciones){
            listaCancionesDTO.add(mapToCancionDTO(cancion));
        }
        return listaCancionesDTO;
    }


}

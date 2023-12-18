package com.informatorio.java.mapper;

import com.informatorio.java.dto.genero.GeneroDTO;
import com.informatorio.java.model.Genero;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeneroMapper {

    public static GeneroDTO mapToGeneroDTO(Genero genero){

        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.setId(genero.getId());
        generoDTO.setNombre(genero.getNombre());

        return generoDTO;
    }

    public static Genero mapToGenero(GeneroDTO generoDTO){

        Genero genero = new Genero();
        genero.setId(generoDTO.getId());
        genero.setNombre(generoDTO.getNombre());

        return genero;
    }


    public static List<GeneroDTO> mapToListaGenerosDTO(List<Genero> listaGeneros){
        List<GeneroDTO> listaGenerosDTO = new ArrayList<>();

        for (Genero genero : listaGeneros){
             listaGenerosDTO.add(mapToGeneroDTO(genero));
        }
         return listaGenerosDTO;
    }

    public static List<Genero> mapToListaGeneros(List<GeneroDTO> listaGenerosDTO){
        List<Genero> listaGeneros = new ArrayList<>();

        for (GeneroDTO generoDTO : listaGenerosDTO){
            listaGeneros.add(mapToGenero(generoDTO));
        }
        return listaGeneros;
    }
}

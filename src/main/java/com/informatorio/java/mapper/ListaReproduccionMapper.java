package com.informatorio.java.mapper;

import com.informatorio.java.dto.listaReproduccion.ListaReproduccionDTO;
import com.informatorio.java.dto.listaReproduccion.ListaReproduccionUsuarioDTO;
import com.informatorio.java.model.ListaReproduccion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ListaReproduccionMapper {


    public static ListaReproduccion mapToListaDeReproduccion(ListaReproduccionUsuarioDTO listaReproduccionUsuarioDTO){

        ListaReproduccion listaReproduccion = new ListaReproduccion();
        listaReproduccion.setId(listaReproduccionUsuarioDTO.getId());
        listaReproduccion.setNombre(listaReproduccionUsuarioDTO.getNombre());

        return listaReproduccion;
    }

    public static ListaReproduccionUsuarioDTO mapToListaDeReproduccionDTO(ListaReproduccion listaReproduccion){


        ListaReproduccionUsuarioDTO listaReproduccionUsuarioDTO = new ListaReproduccionUsuarioDTO();
        listaReproduccionUsuarioDTO.setId(listaReproduccion.getId());
        listaReproduccionUsuarioDTO.setNombre(listaReproduccion.getNombre());

        return listaReproduccionUsuarioDTO;
    }

    public static List<ListaReproduccionUsuarioDTO> mapToListasDeReproduccionDTO(List<ListaReproduccion> listasDeReproduccion){

        List<ListaReproduccionUsuarioDTO> listasDeReproduccionDTO = new ArrayList<>();

        for (ListaReproduccion listaReproduccion : listasDeReproduccion){
            listasDeReproduccionDTO.add(mapToListaDeReproduccionDTO(listaReproduccion));
        }

        return listasDeReproduccionDTO;
    }

    public static List<ListaReproduccion> mapToListasDeReproduccion(List<ListaReproduccionUsuarioDTO> listasDeReproduccionDTO){

        List<ListaReproduccion> listasDeReproduccion = new ArrayList<>();

        for(ListaReproduccionUsuarioDTO listaReproduccionUsuarioDTO : listasDeReproduccionDTO){
            listasDeReproduccion.add(mapToListaDeReproduccion(listaReproduccionUsuarioDTO));
        }

        return listasDeReproduccion;
    }

    public static ListaReproduccionUsuarioDTO mapToListaDeReproduccionUsuarioDTO(ListaReproduccion listaReproduccion){


        ListaReproduccionUsuarioDTO listaReproduccionUsuarioDTO = new ListaReproduccionUsuarioDTO();
        listaReproduccionUsuarioDTO.setId(listaReproduccion.getId());
        listaReproduccionUsuarioDTO.setNombre(listaReproduccion.getNombre());
        listaReproduccionUsuarioDTO.setCantCanciones(listaReproduccion.getCanciones().size());

        return listaReproduccionUsuarioDTO;
    }

    public static List<ListaReproduccionUsuarioDTO> mapToListasDeReproduccionUsuarioDTO(List<ListaReproduccion> listasReproduccion){
        List<ListaReproduccionUsuarioDTO> listasReproduccionUsuarioDTO = new ArrayList<>();
        for (ListaReproduccion listaReproduccion : listasReproduccion){
            listasReproduccionUsuarioDTO.add(mapToListaDeReproduccionUsuarioDTO(listaReproduccion));
        }
        return listasReproduccionUsuarioDTO;
    }

    public static ListaReproduccionDTO mapToListaReproduccionDTO(ListaReproduccion listaReproduccion){

        CancionMapper cancionMapper = new CancionMapper();

        ListaReproduccionDTO listaReproduccionDTO = new ListaReproduccionDTO();
        listaReproduccionDTO.setId(listaReproduccion.getId());
        listaReproduccionDTO.setNombre((listaReproduccion.getNombre()));
        listaReproduccionDTO.setListaCancionesDTO(cancionMapper.mapToListaCancionesDTO(listaReproduccion.getCanciones()));

        return listaReproduccionDTO;
    }



}

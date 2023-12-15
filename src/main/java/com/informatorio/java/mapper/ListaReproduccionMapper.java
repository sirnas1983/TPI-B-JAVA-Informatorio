package com.informatorio.java.mapper;

import com.informatorio.java.dto.listaReproduccion.ListaReproduccionDTO;
import com.informatorio.java.model.ListaReproduccion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ListaReproduccionMapper {


    public ListaReproduccion mapToListaDeReproduccion(ListaReproduccionDTO listaReproduccionDTO){


        UsuarioMapper usuarioMapper = new UsuarioMapper();
        CancionMapper cancionMapper = new CancionMapper();

        ListaReproduccion listaReproduccion = new ListaReproduccion();
        listaReproduccion.setId(listaReproduccionDTO.getId());
        listaReproduccion.setNombre(listaReproduccionDTO.getNombre());
        listaReproduccion.setCanciones(cancionMapper.mapToListaCanciones(listaReproduccionDTO.getCanciones()));

        return listaReproduccion;
    }

    public ListaReproduccionDTO mapToListaDeReproduccionDTO(ListaReproduccion listaReproduccion){

        UsuarioMapper usuarioMapper = new UsuarioMapper();
        CancionMapper cancionMapper = new CancionMapper();

        ListaReproduccionDTO listaReproduccionDTO = new ListaReproduccionDTO();
        listaReproduccionDTO.setId(listaReproduccion.getId());
        listaReproduccionDTO.setNombre(listaReproduccion.getNombre());
        listaReproduccionDTO.setCanciones(cancionMapper.mapToListaCancionesDTO(listaReproduccion.getCanciones()));

        return listaReproduccionDTO;
    }

    public List<ListaReproduccionDTO> mapToListasDeReproduccionDTO(List<ListaReproduccion> listasDeReproduccion){

        List<ListaReproduccionDTO> listasDeReproduccionDTO = new ArrayList<>();

        for (ListaReproduccion listaReproduccion : listasDeReproduccion){
            listasDeReproduccionDTO.add(mapToListaDeReproduccionDTO(listaReproduccion));
        }

        return listasDeReproduccionDTO;
    }

    public List<ListaReproduccion> mapToListasDeReproduccion(List<ListaReproduccionDTO> listasDeReproduccionDTO){

        List<ListaReproduccion> listasDeReproduccion = new ArrayList<>();

        for(ListaReproduccionDTO listaReproduccionDTO : listasDeReproduccionDTO){
            listasDeReproduccion.add(mapToListaDeReproduccion(listaReproduccionDTO));
        }

        return listasDeReproduccion;
    }


}

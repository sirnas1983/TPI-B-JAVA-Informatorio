package com.informatorio.java.service.listaReproduccion;

import com.informatorio.java.dto.ListaReproduccionDTO;
import com.informatorio.java.mapper.ListaReproduccionMapper;
import com.informatorio.java.model.ListaReproduccion;
import com.informatorio.java.repository.ListaReproduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ListaReproduccionServiceImpl implements ListaReproduccionService{

    @Autowired
    ListaReproduccionRepository listaReproduccionRepository;
    @Autowired
    ListaReproduccionMapper listaReproduccionMapper;

    @Override
    public ListaReproduccionDTO traerPorId(String id) {
        Optional<ListaReproduccion> listaReproduccion = listaReproduccionRepository.findById(id);
        if(listaReproduccion.isPresent()){
            return listaReproduccionMapper.mapToListaDeReproduccionDTO(listaReproduccion.get());
        }
        return null;
    }

    @Override
    public List<ListaReproduccionDTO> traerTodos() {
        return listaReproduccionMapper.mapToListasDeReproduccionDTO(listaReproduccionRepository.findAll());
    }

    @Override
    public void modificar(ListaReproduccionDTO listaReproduccionDTO){
        listaReproduccionRepository.save(listaReproduccionMapper.mapToListaDeReproduccion(listaReproduccionDTO));
    }

    @Override
    public void cargar(ListaReproduccionDTO listaReproduccionDTO) {
        listaReproduccionRepository.save(listaReproduccionMapper.mapToListaDeReproduccion(listaReproduccionDTO));
    }

    @Override
    public void eliminar(ListaReproduccionDTO listaReproduccionDTO) {
        listaReproduccionRepository.delete(listaReproduccionMapper.mapToListaDeReproduccion(listaReproduccionDTO));
    }
}

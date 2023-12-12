package com.informatorio.java.service.cancion;

import com.informatorio.java.dto.CancionDTO;
import com.informatorio.java.mapper.CancionMapper;
import com.informatorio.java.model.Cancion;
import com.informatorio.java.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CancionServiceImpl implements CancionService{

    @Autowired
    CancionRepository cancionRepository;
    @Autowired
    CancionMapper cancionMapper;

    @Override
    public CancionDTO traerPorId(String id) {
        Optional<Cancion> cancion = cancionRepository.findById(id);
        if (cancion.isPresent()){
            return cancionMapper.mapToCancionDTO(cancion.get());
        }
        return null ;
    }

    @Override
    public List<CancionDTO> traerTodos() {
        return cancionMapper.mapToListaCancionesDTO(cancionRepository.findAll());
    }

    @Override
    public void modificar(CancionDTO cancionDTO) {
        cancionRepository.save(cancionMapper.mapToCancion(cancionDTO));
    }

    @Override
    public void cargar(CancionDTO cancionDTO) {
        cancionRepository.save(cancionMapper.mapToCancion(cancionDTO));
    }

    @Override
    public void eliminar(CancionDTO cancionDTO) {
        cancionRepository.delete(cancionMapper.mapToCancion(cancionDTO));
    }
}

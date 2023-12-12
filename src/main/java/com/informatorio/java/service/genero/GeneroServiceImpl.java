package com.informatorio.java.service.genero;

import com.informatorio.java.dto.GeneroDTO;
import com.informatorio.java.mapper.GeneroMapper;
import com.informatorio.java.model.Genero;
import com.informatorio.java.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    GeneroRepository generoRepository;
    @Autowired
    GeneroMapper generoMapper;

    @Override
    public GeneroDTO traerPorId(String id) {
        Optional<Genero> genero = generoRepository.findById(id);
        if (genero.isPresent()){
            return generoMapper.mapToGeneroDTO(genero.get());
        }
        return null;
    }

    @Override
    public List<GeneroDTO> traerTodos() {
        return generoMapper.mapToListaGenerosDTO(generoRepository.findAll());
    }

    @Override
    public void modificar(GeneroDTO generoDTO) {
        generoRepository.save(generoMapper.mapToGenero(generoDTO));
    }

    @Override
    public void cargar(GeneroDTO generoDTO) {
        generoRepository.save(generoMapper.mapToGenero(generoDTO));
    }

    @Override
    public void eliminar(GeneroDTO generoDTO) {
        generoRepository.delete(generoMapper.mapToGenero(generoDTO));
    }
}

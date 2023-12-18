package com.informatorio.java.service.genero;

import com.informatorio.java.dto.genero.GeneroDTO;
import com.informatorio.java.exceptions.NotFoundException;
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

    @Override
    public GeneroDTO traerPorId(String id) {
        Optional<Genero> genero = generoRepository.findById(id);
        if (genero.isPresent()){
            return GeneroMapper.mapToGeneroDTO(genero.get());
        } else {
            throw new NotFoundException("Genero", "Genero id", id);
        }
    }

    @Override
    public List<GeneroDTO> traerTodos() {
        return GeneroMapper.mapToListaGenerosDTO(generoRepository.findAll());
    }

    @Override
    public void cargar(GeneroDTO generoDTO) {
        generoRepository.save(GeneroMapper.mapToGenero(generoDTO));
    }

}

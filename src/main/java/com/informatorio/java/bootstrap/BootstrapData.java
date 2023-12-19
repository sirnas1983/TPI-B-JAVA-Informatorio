package com.informatorio.java.bootstrap;

import com.informatorio.java.model.*;
import com.informatorio.java.repository.CancionRepository;
import com.informatorio.java.repository.ListaReproduccionRepository;
import com.informatorio.java.repository.UsuarioRepository;
import com.informatorio.java.service.listaReproduccion.ListaReproduccionService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private UsuarioRepository usuarioRepository;
    private ListaReproduccionRepository listaReproduccionRepository;


    @Override
    public void run(String... args) throws Exception {
        cargarUsuario();
        cargarListaReproduccion();
    }

    @Transactional
    public void cargarUsuario(){
        if(usuarioRepository.count() == 0) {
            Usuario usuario = new Usuario();
            usuario.setNombre("Usuario 1");
            usuario.setNombreUsuario("nombre_usuario_1");
            Auditor auditor = new Auditor();
            auditor.setFechaRegistro(LocalDate.now());
            auditor.setFechaModificacion(LocalDate.now());
            usuario.setAuditor(auditor);
            usuario.setListasDeReproduccion(new ArrayList<>());

            usuarioRepository.save(usuario);
        }
    }


    @Transactional
    public void cargarListaReproduccion(){

        if (listaReproduccionRepository.count()==0) {

            Cancion cancion = new Cancion();
            cancion.setNombre("Cancion 2");
            cancion.setAlbum("Album 1");
            cancion.setDuracion(5.32f);
            cancion.setRanking(8);
            Artista artista = new Artista();
            artista.setNombre("Artista2");
            cancion.setArtista(artista);
            Genero genero1 = new Genero("Marcha");
            Genero genero2 = new Genero("GothicRock");
            cancion.setGeneros(List.of(genero1, genero2));

            List<Cancion> listaCanciones = List.of(cancion);

            ListaReproduccion listaReproduccion = new ListaReproduccion();
            Auditor auditor = new Auditor();
            auditor.setFechaModificacion(LocalDate.now());
            auditor.setFechaRegistro(LocalDate.now());
            listaReproduccion.setAuditor(auditor);
            listaReproduccion.setNombre("lista3");
            listaReproduccion.setCanciones(listaCanciones);
            listaReproduccion.setUsuario(usuarioRepository.findAll().get(0));
            listaReproduccion.setPublica(false);
            listaReproduccion.setAleatorio(false);
            listaReproduccion.setRepetir(false);

            listaReproduccionRepository.save(listaReproduccion);
        }

    }
}

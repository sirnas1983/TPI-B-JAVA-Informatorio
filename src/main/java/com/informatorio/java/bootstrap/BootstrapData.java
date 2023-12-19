package com.informatorio.java.bootstrap;

import com.informatorio.java.model.*;
import com.informatorio.java.repository.CancionRepository;
import com.informatorio.java.repository.ListaReproduccionRepository;
import com.informatorio.java.repository.UsuarioRepository;
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
    private CancionRepository cancionRepository;
    private ListaReproduccionRepository listaReproduccionRepository;

    @Override
    public void run(String... args) throws Exception {
        cargarUsuario();
        cargarCancion();
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
    public void cargarCancion(){
        if(cancionRepository.count() == 0) {
            Cancion cancion = new Cancion();
            cancion.setNombre("Cancion 1");
            cancion.setAlbum("Album 1");
            cancion.setDuracion(5.32f);
            cancion.setRanking(8);

            Artista artista = new Artista();
            artista.setNombre("Artista1");

            cancion.setArtista(artista);

            Genero genero1 = new Genero("Lento");
            Genero genero2 = new Genero("SoftRock");

            cancion.setGeneros(List.of(genero1, genero2));

            cancionRepository.save(cancion);
        }
    }

    // TODO: Arreglar persistencia
    @Transactional
    public void cargarListaReproduccion(){
        ListaReproduccion listaReproduccion = new ListaReproduccion();

        Cancion cancion = cancionRepository.findAll().get(0);
        Usuario usuario = usuarioRepository.findAll().get(0);

        listaReproduccion.setRepetir(false);
        listaReproduccion.setAleatorio(false);
        listaReproduccion.setPublica(false);

        Auditor auditor = new Auditor();
        auditor.setFechaRegistro(LocalDate.now());
        auditor.setFechaModificacion(LocalDate.now());

        listaReproduccion.setAuditor(auditor);

        listaReproduccion.setNombre("Lista reproduccion 1");
        listaReproduccion.setCanciones(List.of(cancion));
        listaReproduccion.setUsuario(usuario);

        listaReproduccionRepository.save(listaReproduccion);
    }
}

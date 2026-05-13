package com.upc.fc.tp_careme.services;

import com.upc.fc.tp_careme.dtos.ConsejoRequestDTO;
import com.upc.fc.tp_careme.entidades.Consejo;
import com.upc.fc.tp_careme.entidades.Usuario;
import com.upc.fc.tp_careme.repositorios.ConsejoRepository;
import com.upc.fc.tp_careme.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConsejoService {

    @Autowired
    private ConsejoRepository consejoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String publicarConsejo(ConsejoRequestDTO request) {

        Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("El usuario especificado no existe."));


        Consejo consejo = new Consejo();
        consejo.setUsuario(usuario);
        consejo.setTitulo(request.getTitulo());
        consejo.setContenido(request.getContenido());
        consejo.setCategoria(request.getCategoria());
        consejo.setFechaPublicacion(LocalDateTime.now());
        consejo.setActivo(true);


        consejoRepository.save(consejo);

        return "¡Consejo publicado con éxito! Título: '" + consejo.getTitulo() + "'";
    }
}
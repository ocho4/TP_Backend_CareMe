package com.upc.fc.tp_careme.services;

import com.upc.fc.tp_careme.dtos.ReclamoRequestDTO;
import com.upc.fc.tp_careme.entidades.Reclamo;
import com.upc.fc.tp_careme.entidades.Servicio;
import com.upc.fc.tp_careme.entidades.Usuario;
import com.upc.fc.tp_careme.repositorios.ReclamoRepository;
import com.upc.fc.tp_careme.repositorios.ServicioRepository;
import com.upc.fc.tp_careme.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReclamoService {

    @Autowired
    private ReclamoRepository reclamoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    public String registrarReclamo(ReclamoRequestDTO request) {

        Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado."));


        Reclamo reclamo = new Reclamo();
        reclamo.setUsuario(usuario);
        reclamo.setAsunto(request.getAsunto());
        reclamo.setDescripcion(request.getDescripcion());
        reclamo.setEstado("abierto");
        reclamo.setFechaCreacion(LocalDateTime.now());


        if (request.getIdServicio() != null) {
            Servicio servicio = servicioRepository.findById(request.getIdServicio())
                    .orElseThrow(() -> new IllegalArgumentException("El servicio especificado no existe."));
            reclamo.setServicio(servicio);
        }


        Reclamo reclamoGuardado = reclamoRepository.save(reclamo);

        return "Tu reclamo ha sido registrado con el Ticket #" + reclamoGuardado.getIdReclamo() + ". Nuestro equipo de soporte lo revisará pronto.";
    }
}
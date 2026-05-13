package com.upc.fc.tp_careme.controllers;

import com.upc.fc.tp_careme.dtos.MensajeDTO;
import com.upc.fc.tp_careme.dtos.MensajeRequestDTO;
import com.upc.fc.tp_careme.services.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    @PostMapping
    public MensajeDTO registrar(@RequestBody MensajeDTO dto) {
        return mensajeService.insertar(dto);
    }

    @GetMapping
    public List<MensajeDTO> listar() {
        return mensajeService.listar();
    }

    @PostMapping("/enviar")
    public String enviarMensaje(@RequestBody MensajeRequestDTO request) {
        return mensajeService.enviarMensaje(request);
    }

    @GetMapping("/servicio/{idServicio}")
    public List<MensajeDTO> historialPorServicio(@PathVariable Integer idServicio) {
        return mensajeService.historialPorServicio(idServicio);
    }
}
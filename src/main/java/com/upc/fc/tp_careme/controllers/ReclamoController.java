package com.upc.fc.tp_careme.controllers;

import com.upc.fc.tp_careme.dtos.ReclamoRequestDTO;
import com.upc.fc.tp_careme.services.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reclamos")
public class ReclamoController {

    @Autowired
    private ReclamoService reclamoService;

    @PostMapping("/abrir")
    public String abrirReclamo(@RequestBody ReclamoRequestDTO request) {
        return reclamoService.registrarReclamo(request);
    }
}
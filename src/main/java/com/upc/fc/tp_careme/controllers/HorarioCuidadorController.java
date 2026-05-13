package com.upc.fc.tp_careme.controllers;

import com.upc.fc.tp_careme.dtos.HorarioRequestDTO;
import com.upc.fc.tp_careme.services.HorarioCuidadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/horarios")
public class HorarioCuidadorController {

    @Autowired
    private HorarioCuidadorService horarioService;

    @PostMapping("/registrar")
    public String registrarHorario(@RequestBody HorarioRequestDTO request) {
        return horarioService.registrarHorario(request);
    }
}
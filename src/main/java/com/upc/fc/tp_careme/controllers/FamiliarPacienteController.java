package com.upc.fc.tp_careme.controllers;

import com.upc.fc.tp_careme.dtos.FamiliarPacienteDTO;
import com.upc.fc.tp_careme.dtos.FamiliarPacienteRequestDTO;
import com.upc.fc.tp_careme.services.FamiliarPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/familiar-paciente")
public class FamiliarPacienteController {

    @Autowired
    private FamiliarPacienteService service;

    @PostMapping
    public FamiliarPacienteDTO registrar(@RequestBody FamiliarPacienteDTO dto) {
        return service.insertar(dto);
    }

    @GetMapping
    public List<FamiliarPacienteDTO> listar() {
        return service.listar();
    }

    @PostMapping("/vincular")
    public String vincular(@RequestBody FamiliarPacienteRequestDTO request) {
        return service.vincular(request);
    }
}
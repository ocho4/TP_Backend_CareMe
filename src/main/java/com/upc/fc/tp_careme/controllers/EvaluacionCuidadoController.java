package com.upc.fc.tp_careme.controllers;

import com.upc.fc.tp_careme.dtos.EvaluacionCuidadoDTO;
import com.upc.fc.tp_careme.services.EvaluacionCuidadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones-cuidado")
public class EvaluacionCuidadoController {

    @Autowired
    private EvaluacionCuidadoService service;

    @PostMapping
    public EvaluacionCuidadoDTO registrar(@RequestBody EvaluacionCuidadoDTO dto) {
        return service.insertar(dto);
    }

    @GetMapping
    public List<EvaluacionCuidadoDTO> listar() {
        return service.listar();
    }
}
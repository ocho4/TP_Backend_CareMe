package com.upc.fc.tp_careme.controllers;

import com.upc.fc.tp_careme.dtos.TareaServicioDTO;
import com.upc.fc.tp_careme.services.TareaServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas-servicio")
public class TareaServicioController {

    @Autowired
    private TareaServicioService tareaServicioService;

    @PostMapping
    public TareaServicioDTO registrar(@RequestBody TareaServicioDTO dto) {
        return tareaServicioService.insertar(dto);
    }

    @GetMapping
    public List<TareaServicioDTO> listar() {
        return tareaServicioService.listar();
    }
}
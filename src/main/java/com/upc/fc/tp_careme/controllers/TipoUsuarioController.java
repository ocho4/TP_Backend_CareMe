package com.upc.fc.tp_careme.controllers;

import com.upc.fc.tp_careme.dtos.TipoUsuarioDTO;
import com.upc.fc.tp_careme.services.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-usuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @PostMapping
    public TipoUsuarioDTO registrar(@RequestBody TipoUsuarioDTO dto) {
        return tipoUsuarioService.insertar(dto);
    }

    @GetMapping
    public List<TipoUsuarioDTO> listar() {
        return tipoUsuarioService.listar();
    }
}
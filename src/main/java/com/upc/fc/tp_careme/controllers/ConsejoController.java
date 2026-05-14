package com.upc.fc.tp_careme.controllers;

import com.upc.fc.tp_careme.dtos.ConsejoRequestDTO;
import com.upc.fc.tp_careme.services.ConsejoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consejos")
public class ConsejoController {

    @Autowired
    private ConsejoService consejoService;

    @PostMapping("/publicar")
    public String publicarConsejo(@RequestBody ConsejoRequestDTO request) {
        return consejoService.publicarConsejo(request);
    }
}
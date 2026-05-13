package com.upc.fc.tp_careme.services;

import com.upc.fc.tp_careme.dtos.AdministradorDTO;
import com.upc.fc.tp_careme.entidades.Administrador;
import com.upc.fc.tp_careme.repositorios.AdministradorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AdministradorDTO insertar(AdministradorDTO dto) {
        Administrador entidad = modelMapper.map(dto, Administrador.class);
        entidad = administradorRepository.save(entidad);
        return modelMapper.map(entidad, AdministradorDTO.class);
    }

    public List<AdministradorDTO> listar() {
        return administradorRepository.findAll()
                .stream()
                .map(entidad -> modelMapper.map(entidad, AdministradorDTO.class))
                .toList();
    }
}
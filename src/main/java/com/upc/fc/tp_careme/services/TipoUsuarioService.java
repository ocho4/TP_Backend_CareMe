package com.upc.fc.tp_careme.services;

import com.upc.fc.tp_careme.dtos.TipoUsuarioDTO;
import com.upc.fc.tp_careme.entidades.TipoUsuario;
import com.upc.fc.tp_careme.repositorios.TipoUsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    private ModelMapper modelMapper;


    public TipoUsuarioDTO insertar(TipoUsuarioDTO dto) {
        TipoUsuario entidad = modelMapper.map(dto, TipoUsuario.class);
        entidad = tipoUsuarioRepository.save(entidad);
        return modelMapper.map(entidad, TipoUsuarioDTO.class);
    }


    public List<TipoUsuarioDTO> listar() {
        return tipoUsuarioRepository.findAll()
                .stream()
                .map(entidad -> modelMapper.map(entidad, TipoUsuarioDTO.class))
                .toList();
    }
}
package com.upc.fc.tp_careme.services;

import com.upc.fc.tp_careme.dtos.FamiliarDTO;
import com.upc.fc.tp_careme.dtos.FamiliarRequestDTO;
import com.upc.fc.tp_careme.entidades.Familiar;
import com.upc.fc.tp_careme.entidades.Usuario;
import com.upc.fc.tp_careme.repositorios.FamiliarRepository;
import com.upc.fc.tp_careme.repositorios.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliarService {

    @Autowired
    private FamiliarRepository familiarRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;


    public FamiliarDTO insertar(FamiliarDTO dto) {
        Familiar entidad = modelMapper.map(dto, Familiar.class);
        entidad = familiarRepository.save(entidad);
        return modelMapper.map(entidad, FamiliarDTO.class);
    }

    public List<FamiliarDTO> listar() {
        return familiarRepository.findAll()
                .stream()
                .map(entidad -> modelMapper.map(entidad, FamiliarDTO.class))
                .toList();
    }


    public FamiliarDTO completarPerfil(FamiliarRequestDTO request) {

        Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("El usuario especificado no existe."));


        Familiar familiar = new Familiar();
        familiar.setUsuario(usuario);
        familiar.setDireccion(request.getDireccion());
        familiar.setDistrito(request.getDistrito());


        familiar = familiarRepository.save(familiar);

        return modelMapper.map(familiar, FamiliarDTO.class);
    }
}
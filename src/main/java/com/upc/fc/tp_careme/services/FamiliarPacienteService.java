package com.upc.fc.tp_careme.services;

import com.upc.fc.tp_careme.dtos.FamiliarPacienteDTO;
import com.upc.fc.tp_careme.dtos.FamiliarPacienteRequestDTO;
import com.upc.fc.tp_careme.entidades.Familiar;
import com.upc.fc.tp_careme.entidades.FamiliarPaciente;
import com.upc.fc.tp_careme.entidades.Paciente;
import com.upc.fc.tp_careme.repositorios.FamiliarPacienteRepository;
import com.upc.fc.tp_careme.repositorios.FamiliarRepository;
import com.upc.fc.tp_careme.repositorios.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliarPacienteService {

    @Autowired
    private FamiliarPacienteRepository repository;

    @Autowired
    private FamiliarRepository familiarRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ModelMapper modelMapper;


    public FamiliarPacienteDTO insertar(FamiliarPacienteDTO dto) {
        FamiliarPaciente entidad = modelMapper.map(dto, FamiliarPaciente.class);
        entidad = repository.save(entidad);
        return modelMapper.map(entidad, FamiliarPacienteDTO.class);
    }

    public List<FamiliarPacienteDTO> listar() {
        return repository.findAll()
                .stream()
                .map(entidad -> modelMapper.map(entidad, FamiliarPacienteDTO.class))
                .toList();
    }


    public String vincular(FamiliarPacienteRequestDTO request) {

        Familiar familiar = familiarRepository.findById(request.getIdFamiliar())
                .orElseThrow(() -> new IllegalArgumentException("Familiar no encontrado."));

        Paciente paciente = pacienteRepository.findById(request.getIdPaciente())
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado."));


        FamiliarPaciente vinculo = new FamiliarPaciente();
        vinculo.setFamiliar(familiar);
        vinculo.setPaciente(paciente);
        vinculo.setParentesco(request.getParentesco());


        vinculo.setEsPrincipal(request.getEsPrincipal() != null ? request.getEsPrincipal() : true);


        repository.save(vinculo);

        return "Vinculación exitosa: " + familiar.getUsuario().getNombres() + " ahora es responsable de " + paciente.getUsuario().getNombres();
    }
}
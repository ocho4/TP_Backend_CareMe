package com.upc.fc.tp_careme.repositorios;

import com.upc.fc.tp_careme.entidades.FamiliarPaciente;
import com.upc.fc.tp_careme.entidades.FamiliarPacienteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliarPacienteRepository extends JpaRepository<FamiliarPaciente, FamiliarPacienteId> {
}
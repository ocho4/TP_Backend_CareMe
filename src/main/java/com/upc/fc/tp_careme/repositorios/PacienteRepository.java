package com.upc.fc.tp_careme.repositorios;

import com.upc.fc.tp_careme.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}

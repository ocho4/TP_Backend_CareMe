package com.upc.fc.tp_careme.repositorios;

import com.upc.fc.tp_careme.entidades.RecordatorioMedicacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordatorioMedicacionRepository extends JpaRepository<RecordatorioMedicacion, Integer> {
    List<RecordatorioMedicacion> findByPacienteIdPacienteAndTomadoFalse(Integer idPaciente);
}

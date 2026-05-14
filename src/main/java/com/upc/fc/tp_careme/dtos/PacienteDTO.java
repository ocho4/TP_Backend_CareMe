package com.upc.fc.tp_careme.dtos;

import lombok.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {
    private Integer idPaciente;
    private UsuarioDTO usuario;
    private LocalDate fechaNacimiento;
    private String necesidadesEspecificas;
}
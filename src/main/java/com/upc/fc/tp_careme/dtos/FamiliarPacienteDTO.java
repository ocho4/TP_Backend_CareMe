package com.upc.fc.tp_careme.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FamiliarPacienteDTO {
    private FamiliarDTO familiar;
    private PacienteDTO paciente;
    private String parentesco;
    private Boolean esPrincipal;
}
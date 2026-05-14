package com.upc.fc.tp_careme.dtos;

import lombok.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CuidadorDTO {
    private Integer idCuidador;
    private UsuarioDTO usuario;
    private String especialidad;
    private String ubicacion;
    private String disponibilidadTexto;
    private Double tarifaBase;
    private Double calificacionPromedio;
    private Boolean activo;
    private Boolean observado;
    private List<CondicionMedicaDTO> condiciones;
}
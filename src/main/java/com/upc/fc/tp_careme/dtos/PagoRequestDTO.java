package com.upc.fc.tp_careme.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PagoRequestDTO {
    private Integer idServicio;
    private Double monto;
    private String telefonoYape;
    private String codigoOperacion;
}
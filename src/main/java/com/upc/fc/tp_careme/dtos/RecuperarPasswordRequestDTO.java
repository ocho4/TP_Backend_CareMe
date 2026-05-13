package com.upc.tp_careme.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecuperarPasswordRequestDTO {
    private String email;
    private String telefono;
}

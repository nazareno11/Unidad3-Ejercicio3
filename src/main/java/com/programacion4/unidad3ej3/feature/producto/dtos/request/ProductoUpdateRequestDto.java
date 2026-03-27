package com.programacion4.unidad3ej3.feature.producto.dtos.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoUpdateRequestDto {
    @NotNull
    private String nombre;
    @NotNull
    private String codigo;
    @NotNull
    private String descripcion;
    @NotNull
    private Double precio;
    @NotNull
    private Integer stock;
}

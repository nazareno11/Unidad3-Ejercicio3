package com.programacion4.unidad3ej3.feature.producto.controllers.post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoUpdateService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/productos")
public class ProductoUpdateController {

    private final IProductoUpdateService productoUpdateService;

    public ProductoUpdateController(IProductoUpdateService productoUpdateService) {
        this.productoUpdateService = productoUpdateService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductoUpdateRequestDto dto) {

        return ResponseEntity.ok(productoUpdateService.update(id, dto));
    }
}

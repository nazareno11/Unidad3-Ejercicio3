package com.programacion4.unidad3ej3.feature.producto.controllers.post;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGetService;

@RestController
@RequestMapping("/productos")
public class ProductoGetController {

    private final IProductoGetService productoGetService;

    public ProductoGetController(IProductoGetService productoGetService) {
        this.productoGetService = productoGetService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponseDto>> getAll() {
        return ResponseEntity.ok(productoGetService.getAll());
    }
}
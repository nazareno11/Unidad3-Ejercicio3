package com.programacion4.unidad3ej3.feature.producto.controllers.post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoDeleteService;

@RestController
@RequestMapping("/productos")
public class ProductoDeleteController {

    private final IProductoDeleteService productoDeleteService;

    public ProductoDeleteController(IProductoDeleteService productoDeleteService) {
        this.productoDeleteService = productoDeleteService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productoDeleteService.delete(id);
        return ResponseEntity.noContent().build(); 
    }
}


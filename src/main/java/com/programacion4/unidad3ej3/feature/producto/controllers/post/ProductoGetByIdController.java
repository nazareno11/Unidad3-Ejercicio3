package com.programacion4.unidad3ej3.feature.producto.controllers.post;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGetByIdService;

@RestController
@RequestMapping("/productos")
 

public class ProductoGetByIdController {
    private final IProductoGetByIdService productoGetByIdService;
    public ProductoGetByIdController(IProductoGetByIdService productoGetByIdService){
        this.productoGetByIdService = productoGetByIdService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(productoGetByIdService.getById(id));
    }



}

package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoDeleteService;

@Service
public class ProductoDeleteService implements IProductoDeleteService {

    private final IProductoRepository productoRepository;

    public ProductoDeleteService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void delete(Long id) {

        Producto producto = productoRepository
                .findByIdAndEstaEliminadoFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        producto.setEstaEliminado(true);

        productoRepository.save(producto);
    }
}

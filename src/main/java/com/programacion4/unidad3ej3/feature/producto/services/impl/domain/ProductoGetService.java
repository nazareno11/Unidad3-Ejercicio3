package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGetService;

@Service
public class ProductoGetService implements IProductoGetService {

    private final IProductoRepository productoRepository;

    public ProductoGetService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<ProductoResponseDto> getAll() {
        List<Producto> productos = productoRepository.findAllByEstaEliminadoFalse();

        return productos.stream()
                .map(producto -> new ProductoResponseDto(
                        producto.getId(),
                        producto.getNombre(),
                        producto.getCodigo(),
                        producto.getDescripcion(),
                        producto.getPrecio(),
                        producto.getStock()
                ))
                .toList();
    }
}
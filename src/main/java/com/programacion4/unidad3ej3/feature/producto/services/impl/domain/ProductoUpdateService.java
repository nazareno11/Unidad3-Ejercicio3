package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoUpdateService;


@Service
public class ProductoUpdateService implements IProductoUpdateService {

    private final IProductoRepository productoRepository;

    public ProductoUpdateService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductoResponseDto update(Long id, ProductoUpdateRequestDto dto) {

        Producto producto = productoRepository
                .findByIdAndEstaEliminadoFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        
        producto.setNombre(dto.getNombre());
        producto.setCodigo(dto.getCodigo());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());

        Producto guardado = productoRepository.save(producto);

        return new ProductoResponseDto(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getCodigo(),
                guardado.getDescripcion(),
                guardado.getPrecio(),
                guardado.getStock()
        );
    }
}

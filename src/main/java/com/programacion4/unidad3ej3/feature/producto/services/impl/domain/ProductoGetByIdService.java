package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGetByIdService;

@Service
public class ProductoGetByIdService implements IProductoGetByIdService {
    private final IProductoRepository productoRepository;
    public ProductoGetByIdService(IProductoRepository productoRepository){
        this.productoRepository= productoRepository;
    }
    
    @Override
    public ProductoResponseDto getById(Long id){
        Producto producto = productoRepository.findByIdAndEstaEliminadoFalse(id)
        .orElseThrow(()-> new ResourceNotFoundException("Poroducto no encontrado con id: "+ id));

        return new ProductoResponseDto(
            producto.getId(),
            producto.getNombre(),
            producto.getCodigo(),
            producto.getDescripcion(),
            producto.getPrecio(),
            producto.getStock()
        );
    }



}

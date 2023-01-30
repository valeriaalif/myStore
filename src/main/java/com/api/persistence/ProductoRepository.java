package com.api.persistence;

import com.api.persistence.crud.ProductoCrudRepository;
import com.api.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List <Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();

    }
    public List<Producto> getByCategoria(int idCataegoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCataegoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad, boolean estado){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, estado);
    }

    public Optional<Producto>getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }


}

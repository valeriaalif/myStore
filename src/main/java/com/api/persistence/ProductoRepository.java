package com.api.persistence;

import com.api.domain.Product;
import com.api.domain.repository.ProductRepository;
import com.api.persistence.crud.ProductoCrudRepository;
import com.api.persistence.entity.Producto;
import com.api.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;
     @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);

    }
    @Override
    public Optional <List<Producto>> getByCategory(int categoryId){
         List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }
    @Override

    public Optional<List<Producto>> getScarseProducts(int quantity){
      Optional<List<Product>> productos =  productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity);
         return productos.map(prods -> mapper.toProducts(prods));
    }
    @Override
    public Optional<Producto> getProduct(int productId){
         return productoCrudRepository.findById(productId).map(producto -> mapper.toProducto(producto));
    }
    @Override
    public Producto save(Product product){
         Producto producto = mapper.toProducto(product);
         return mapper.toProducto(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }


}

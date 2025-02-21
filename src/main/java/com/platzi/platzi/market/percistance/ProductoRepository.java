package com.platzi.platzi.market.percistance;

import com.platzi.platzi.market.domain.Product;
import com.platzi.platzi.market.domain.repository.ProductRepository;
import com.platzi.platzi.market.percistance.crud.ProductoCrudRepository;
import com.platzi.platzi.market.percistance.entity.Producto;
import com.platzi.platzi.market.percistance.mapper.ProductMapper;
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
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findByIdCategoria(categoryId);
        return productos.isEmpty() ? Optional.empty() :Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>>productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods)); //(mapper::toproducts);
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        Optional<Producto> producto = productoCrudRepository.findById(productId);
        return producto.map(mapper::toProduct);
    }

    @Override
    public Product save(Product product) {
         Producto producto = mapper.toProducto(product);
         return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int idProduct){
        productoCrudRepository.deleteById(idProduct);
    }

}

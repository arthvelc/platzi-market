package com.platzi.platzi.market.percistance;

import com.platzi.platzi.market.percistance.crud.ProductoCrudRepository;
import com.platzi.platzi.market.percistance.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>)productoCrudRepository.findAll(); //Debemos castear en este caso a una lista de producto, pero se debe de castear a lo que nosostros queramos, poruqe el método en si retorna un iterable.
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoria(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

}

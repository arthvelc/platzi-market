package com.platzi.platzi.market.percistance.crud;

import com.platzi.platzi.market.percistance.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //aquí vamos a implementar lo que son los query methods que se pueden ver en la documentación de spring data jpa

    List<Producto>findByIdCategoria(int idCategoria);

    Optional<List<Producto>>findByCantidadStockLessThanAndEstado(int cantidad, boolean estado);
}

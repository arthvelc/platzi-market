package com.platzi.platzi.market.percistance.crud;

import com.platzi.platzi.market.percistance.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //QUERY METHODS
    List<Producto>findByIdCategoria(int idCategoria);

    Optional<List<Producto>>findByCantidadStockLessThanAndEstado(int cantidad, boolean estado);

    //Otros query methods para productos
    //Este metodo permitirá buscar productos cuyo nombre coincida con un valor específico o que contenga una palabra clave:
    List<Producto> findByNombreContaining(String nombre);

    //Buscar productos por precio de venta mayor que un valor específico
    List<Producto> findByPrecioVentaGreaterThan(Double precio);
    //Buscar los productos por estado
    List<Producto> findByEstado(Boolean estado);

    // Buscarproducto por cantidad de stock dentro de un rango específico
    List<Producto> findByCantidadStockBetween(int min, int max);
}

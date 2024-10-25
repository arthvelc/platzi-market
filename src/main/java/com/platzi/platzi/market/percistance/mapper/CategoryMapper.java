package com.platzi.platzi.market.percistance.mapper;

import com.platzi.platzi.market.domain.Category;
import com.platzi.platzi.market.percistance.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    //Mapea todos los campos de la clase Categoria a la clase Category
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);


    //hereda el proceso inverso pero debemos especificar que debemos ignorar los atributos que no queremos mappear en nuestra clase.
    @InheritInverseConfiguration()
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}

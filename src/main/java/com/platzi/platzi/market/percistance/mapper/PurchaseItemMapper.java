package com.platzi.platzi.market.percistance.mapper;

import com.platzi.platzi.market.domain.PurchaseItem;
import com.platzi.platzi.market.percistance.entity.CompraProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId" ),
            @Mapping(source = "cantidad", target = "quantity" ),
            @Mapping(source = "estado", target = "active" ),
    })
    PurchaseItem toPurchaseItem(CompraProducto compraProducto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target="compra", ignore = true),
            @Mapping(target="producto", ignore = true),
            @Mapping(target="id.idCompra", ignore = true)
    })
    CompraProducto toCompraProducto(PurchaseItem purchaseItem);
}

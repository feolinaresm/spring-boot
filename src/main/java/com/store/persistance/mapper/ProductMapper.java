package com.store.persistance.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.store.domain.ProductDTO;
import com.store.persistance.entity.Product;

import java.util.List;

//Como en este mapeo estamos utilizando la categoria y este ya cuenta con su propio mapper
//debemos indicarle a la anotación @Mapper() la referencia para que haga uso de esta
//y así cuando tenga que asignar la categoria, hará la conversión como corresponde
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "productId", target = "id"),
            @Mapping(source = "name", target = "dName"),
            @Mapping(source = "categoryId", target = "dCategoryId"),
            @Mapping(source = "sellPrice", target = "price"),
            @Mapping(source = "quantity", target = "dQuantity"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "category", target = "dCategory")
    })
    ProductDTO toDomainProduct(Product product);
    //Como este es el mismo tipo de converisón que arriba pero apricado a una lista, podemos simplemente definirlo
    List<ProductDTO> toDomainProducts(List<Product> productList);

    @InheritInverseConfiguration
    @Mapping(target = "qrCode", ignore = true)
    Product toProduct(ProductDTO domainProduct);
}

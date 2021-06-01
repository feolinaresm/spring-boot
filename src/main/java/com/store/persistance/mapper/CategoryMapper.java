package com.store.persistance.mapper;

import com.store.domain.CategoryDTO;
import com.store.persistance.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//Esta anotación pertenece a el API Mapstruct y nos permite realizar integración con Spring haciendo uso del atributo
//componentModel = "spring"
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    //Para indicarle como realizar el mapeado hacemos uso de la notación @Mappings y dentro de sus cuerpo cada una de las asignaciones con la anotación @Mapping
    @Mappings({
            @Mapping(source = "categoryId", target = "id"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "status", target = "active")
    })
    CategoryDTO toDomainCategory(Category category);

    //En aquellos casos en los que deseamos realizar la conversión a la inversa, podemos usar la anotación @InheritInverseConfiguration
    //misma que toma el mapeado del primer metodo e invierte los valores, haciendo que funcione para su opuesto, para no tener que repetir el proceso
    //Si observamos la entidad Category vemos que está esperando un atributo de tipo Lista con los productos, como este no lo estamos usando
    //y para evitar errores en la conversión, debemos declarar que dicho atributo será ignorado, con la anotación @Mapping(target = "products", ignore = true)
    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toDomainCategory(CategoryDTO domainCategory);
}

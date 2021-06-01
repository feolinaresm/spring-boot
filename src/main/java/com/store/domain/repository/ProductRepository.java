package com.store.domain.repository;


import com.store.domain.ProductDTO;
import com.store.persistance.entity.Product;

import java.util.List;

//En esta interfaz estamos definiendo las reglas que aplicaran aquellas clases/repositorios encargadas de interactuar con la DB cuando se trate de un Producto
public interface ProductRepository {
    List<ProductDTO> getAll();
    List<ProductDTO> getById(int categoryId);
    ProductDTO saveProduct(ProductDTO productDTO);
    void deleteProduct(int productId);

}

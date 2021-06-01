package com.store.persistance;

import com.store.domain.ProductDTO;
import com.store.persistance.crud.ProductCrudRepository;
import com.store.persistance.entity.Product;
import com.store.persistance.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//Como esta es una clase que se encarga de interactuar con la base de datos directamente,
//es buena práctica hacer uso de la anotación:
@Repository //Tambien podriamos haber usado la anotación @Component, pero esta es una generalización, que define la clase como un componente de Spring sin más
public class ProductRepository implements com.store.domain.repository.ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    //Aquí estamos haciendo uso de los repositorios, es asi de sencillo
    @Override
    public List<ProductDTO> getAll(){
        List<Product> productList = (List<Product>) productCrudRepository.findAll();
        return mapper.toDomainProducts(productList);
    }

    @Override
    public List<ProductDTO> getById(int productId){
        List<Product> productList = productCrudRepository.findByProductIdOrderByNameAsc(productId);
        return mapper.toDomainProducts(productList);
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = mapper.toProduct(productDTO);
        return mapper.toDomainProduct(productCrudRepository.save(product));
    }

    @Override
    public void deleteProduct(int productId) {
        productCrudRepository.deleteById(productId);
    }
}

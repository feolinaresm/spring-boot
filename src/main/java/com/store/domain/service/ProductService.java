package com.store.domain.service;

import com.store.domain.ProductDTO;
import com.store.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//Nuevamente, esta anotación no es más que una formalidad necesaria para identificar una clase con un rol especifico
@Service
public class ProductService {

    //Aquí estamos inyectando una dependencia, en este caso la interfaz ProductRepository
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAll(){
        return productRepository.getAll();
    }

    public List<ProductDTO> getProductsByCategory(int categoryId){
        return productRepository.getById(categoryId);
    }

    public void delete(int productId){
        productRepository.deleteProduct(productId);
    }

    public ProductDTO save(ProductDTO productDTO){
        return productRepository.saveProduct(productDTO);
    }
}

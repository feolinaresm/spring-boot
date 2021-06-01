package com.store.web.controller;

import com.store.domain.ProductDTO;
import com.store.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Esta anotación le indica a Spring que esta clase va a ser un controlador de un API Rest
@RestController
@RequestMapping("/product") //Define el path en el que estará ubicdo para recibir las peticiones
public class ProductController {

    @Autowired
    private ProductService productService;

    //Para exponer nuestros metodos con el formato http (update, delete, post, get), debemos hacer uso de unas anotaciones especiales
    //con el fin de identificar cada uno de estos como un http request especifico

    //El objeto ]ResponseEntity nos sirve para mejorar la calidad de las respuestas/peticiones y tener un mejor control sobre las mismas
    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    //La anotación request body usa el contenido del cuerpo de la petición y lo mapea a el tipo de objeto que requerimos
    @PostMapping("/save")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.save(productDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{productId}")
    public void delete(@PathVariable("productId") int productId){
        productService.delete(productId);
    }
}

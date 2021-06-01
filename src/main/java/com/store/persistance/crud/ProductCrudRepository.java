package com.store.persistance.crud;

import com.store.persistance.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//En esta ocasión haremos uso del CrudRepository perteneciente al modulo de Spring Data, mismo que recibe dos parametros,
//la tabla y el tipo de la llave primaria, lo único que necesitamos para poder hacer uso de este repositorio y sus metodos es crear un objeto de esta
//interfaz y hacer el llamado del método respectivo que necesitemos
public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

    //Esto es un query method
    //Cuando tenemos la anotación @Query no es necesario hacer uso de la nomenclatura de nombres, pues esta es solo una alternativa
    //@Query(value = "SELECT * FROM products WHERE id_producto = ?", nativeQuery = true)
    List<Product> findByProductIdOrderByNameAsc(int productId);
}

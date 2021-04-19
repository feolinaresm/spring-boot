package com.store.persistance.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer categoryId;

    private String description;

    @Column(name = "estado")
    private Boolean status;

    @OneToMany(mappedBy = "category") //Debido a que en esta ocasión quien puede contener muchos elementos de la otra clase es la actual, usaremos una lista para que sea capaz de contenerlos
    //Category es el nombre del atributo que creamos para representar la relación en la clase/tabla Product, esto con la finalidad de respaldar y afirmar la relación
    private List<Product> products;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId= categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

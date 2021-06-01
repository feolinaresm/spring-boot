package com.store.persistance.entity;

import javax.persistence.*;

@Entity //Esta clase se comportará como una clase que mapea una tabla de DB, es la más importante
@Table(name = "productos")
public class Product {

    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esta incrementará el valor automaticamente, la estrategia se agrega puesto que es de tipo identidad es decir, un id, asi Java tambien lo generará de forma automatica
    private Integer productId; //No debemos usar los tipos de datos primitivos sino los empaquetado

    @Column(name = "nombre")
    private String name;

    @Column(name = "id_categoria")
    private Integer categoryId;

    @Column(name = "codigo_barras")
    private String qrCode;

    @Column(name = "precio_venta")
    private Double sellPrice;

    @Column(name = "cantidad_stock")
    private Integer quantity;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne //Define la relación que existe entre la tabla producto y la tabla categoria
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false) //Lo que le estamos diciendo con estas dos ultimas propiedades es que, a traves de esta relación no vamos ni a borrar ni a actualizar la tabla categorias
    private Category category;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

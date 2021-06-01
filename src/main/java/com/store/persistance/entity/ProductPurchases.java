package com.store.persistance.entity;

import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ProductPurchases {
    //Debido a que tenemos dos claves primarias no podemos simplemente agregarlas en nuestra clase,
    //debemos crear otra que las contenga

    @EmbeddedId //Debido a que nuestra clave primaria es compuesta ya no usaremos @Id
    private ProductPurchasesPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    private Double total;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne
    @MapsId("purchaseId") //Esta anotación tambien está relacionada con la actualización en cascada para poder identificar a que compra equivale
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;

    public ProductPurchasesPK getId() {
        return id;
    }

    public void setId(ProductPurchasesPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

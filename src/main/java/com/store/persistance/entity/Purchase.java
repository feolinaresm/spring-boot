package com.store.persistance.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Purchase {
    @Id
    @Column(name = "id_compra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer purchaseId;

    @Column(name = "id_cliente")
    private Integer clientId;

    @Column(name = "fecha")
    private LocalDateTime date;

    @Column(name = "medio_pago")
    private String payWay;

    @Column(name = "comentario")
    private String comment;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false) //Nuevamente, esto se hace con el fin de no permitir modificar la tabla clientes a traves de esta relación
    private Client client;

    @OneToMany(mappedBy = "purchase", cascade = {CascadeType.ALL}) //Esto quiere decir que todos los procesos que se hagan en la base de datos en cuanto a una compra, van a incluir en cascada sus productos
    private List<ProductPurchases> products;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ProductPurchases> getProducts() {
        return products;
    }

    public void setProducts(List<ProductPurchases> products) {
        this.products = products;
    }
}

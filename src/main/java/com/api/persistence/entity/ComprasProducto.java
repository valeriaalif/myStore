package com.api.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
@EmbeddedId
private ComprasProductoPK id;

private Integer canitdad;
private Double total;
private Boolean estado;
@ManyToOne
@JoinColumn(name = "id_compra", insertable = false, updatable = false)
private Compra compra;
@ManyToOne
@JoinColumn(name = "id_producto", insertable = false, updatable = false)
private Producto producto;

    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCanitdad() {
        return canitdad;
    }

    public void setCanitdad(Integer canitdad) {
        this.canitdad = canitdad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}

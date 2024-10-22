package com.platzi.platzi.market.percistance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer idProducto;
    private String nombre;
    @Column(name="id_categoria")
    private Integer idCategoria;
    @Column(name="codigo_barra")
    private String codigoBarra;
    @Column(name="precio_venta")
    private Double PrecioVenta;
    @Column(name="cantidad_stock")
    private Integer cantidadStock;
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name="id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public Double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        PrecioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}

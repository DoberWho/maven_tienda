package com.castelaofpe.maven.tienda.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Carrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = 0;
	
	@ManyToOne
	@JoinColumn(name="id_producto", nullable=false)
	public ProductoVariante productoVariante;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user", nullable=false)
	public Usuario usuario;
	
	@Column(name="amount")
	public int cantidad = 1;

	public ProductoVariante getProductoVariante() {
		return productoVariante;
	}

	public void setProductoVariante(ProductoVariante productoVariante) {
		this.productoVariante = productoVariante;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String toString() {
		return "Item Carrito: "+this.id+" - "+this.productoVariante+" - Amount: "+this.cantidad;
	}
}

package com.castelaofpe.maven.tienda.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto_variante")
public class ProductoVariante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = 0;
	
	@ManyToOne
	@JoinColumn(name="id_producto", nullable=false)
	private Producto producto;
	
	private int stock = 0;
	
	private int precio = 0; 
	
	public String name = "";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "PV: "+this.id+" - N:"+this.name+" -S: "+this.stock+" -P:"+this.precio;
	}
	
}

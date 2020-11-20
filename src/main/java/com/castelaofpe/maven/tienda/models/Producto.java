package com.castelaofpe.maven.tienda.models; 

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Producto {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = 0;
	
	@Column(name="name")
	public String nombre = "";
	
	@Column(name="description")
	public String desc = "";
	public int precio = 0; 
	public int stock = 1;
	
	@ManyToOne
	@JoinColumn(name="id_category", nullable=false)
	public Categoria categoria;
	
	
	@ManyToMany
	@JoinTable(
	  name = "mn_product_tag", 
	  joinColumns = @JoinColumn(name = "id_product"), 
	  inverseJoinColumns = @JoinColumn(name = "id_tag"))
	public List<Tag> etiquetas;
	
 
	/**
	 * 
	 * @return 100 = 1,00
	 */
	public int getPrecio() {
		return precio;
	}
	/**
	 * 
	 * @return 100 = 1,00
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	} 
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	 
	@Override
	public String toString() {
		String res = "ID:"+this.id+" -> Nombre: "+this.nombre+" - Precio: "+this.precio+" - Stock: "+this.stock;;
		if (this.categoria != null) {
			res = res + " => Categoria: "+this.categoria.getNombre();
		}else {
			res = res + " => Categoria: NULL";
		}
		return res;
	}

}

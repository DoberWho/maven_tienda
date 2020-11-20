package com.castelaofpe.maven.tienda.models;


import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tag")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = 0; 
	
	@Column(name="name")
	private String nombre = ""; 
	
	@ManyToMany
	@JoinTable(
	  name = "mn_product_tag", 
	  joinColumns = @JoinColumn(name = "id_tag"), 
	  inverseJoinColumns = @JoinColumn(name = "id_product"))
	public List<Producto> productos;
	
	
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



	@Override
	public String toString() {
		return "ID:"+this.id+" -> Nombre: "+this.nombre;
	}

	
}
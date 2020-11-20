package com.castelaofpe.maven.tienda.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Persona {	 
	  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id = 0;
	
	public String name = "";  
	public String lastname = "";  
	 	 

	public Integer getId() {		
		return id;
	} 

	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	@Override
	public String toString() {
		return "ID:"+this.id+" -> Nombre: "+this.name+" - Apellidos: "+this.lastname; 
	}
	
 
}

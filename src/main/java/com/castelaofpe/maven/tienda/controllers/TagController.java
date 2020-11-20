package com.castelaofpe.maven.tienda.controllers;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.castelaofpe.maven.tienda.models.Categoria;
import com.castelaofpe.maven.tienda.models.Tag; 

public class TagController extends GenericController<Tag> {
	 
	@Override
	public Tag get(int id) {
		return (Tag) entityManager.find(Tag.class, id);
	}

	@Override
	public List<Tag> getAll() {
		Query q03 = entityManager.createQuery("select e from Tag e");  
        return q03.getResultList();
	} 
	

}

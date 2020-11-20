package com.castelaofpe.maven.tienda.controllers;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.castelaofpe.maven.tienda.models.Categoria;
import com.castelaofpe.maven.tienda.models.Producto;
import com.castelaofpe.maven.tienda.models.Usuario;
import com.castelaofpe.maven.tienda.models.ProductoVariante;

public class ProductoVariantController extends GenericController<ProductoVariante>{
	 
	@Override
	public ProductoVariante get(int id) {
		return (ProductoVariante) entityManager.find(ProductoVariante.class, id);
	}

	@Override
	public List<ProductoVariante> getAll() {
		Query q03 = entityManager.createQuery("select e from Producto e");  
        return q03.getResultList();
	} 
	 
	 
}

package com.castelaofpe.maven.tienda.controllers;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.castelaofpe.maven.tienda.models.Carrito;
import com.castelaofpe.maven.tienda.models.Categoria;
import com.castelaofpe.maven.tienda.models.Producto;
import com.castelaofpe.maven.tienda.models.Usuario;

public class CarritoController extends GenericController<Carrito> {


	@Override
	public List<Carrito> getAll() {
		Query q03 = entityManager.createQuery("select e from Carrito e");  
        return q03.getResultList();
	}
	
	@Override
	Carrito get(int id) {
		// TODO Auto-generated method stub
		return null;
	} 	 
 
	public List<Carrito> getByUser(int id) {
		UsuarioController uCtrl = new UsuarioController();
		Usuario itemUsuario = uCtrl.get(id);
		
		String strQuery = "select e from Carrito e WHERE e.usuario = :user";
		Query query = entityManager.createQuery(strQuery);
		query.setParameter("user", itemUsuario); 
        return query.getResultList();
	}   

	

	 
}

package com.castelaofpe.maven.tienda.controllers;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.castelaofpe.maven.tienda.models.Categoria;
import com.castelaofpe.maven.tienda.models.Producto;
import com.castelaofpe.maven.tienda.models.Usuario;

public class ProductoController extends GenericController<Producto>{
	 
	@Override
	public Producto get(int id) {
		return (Producto) entityManager.find(Producto.class, id);
	}

	@Override
	public List<Producto> getAll() {
		Query q03 = entityManager.createQuery("select e from Producto e");  
        return q03.getResultList();
	} 
	 
	
	public List<Producto> getByCategoria(Categoria c) { 
		Query q03 = entityManager.createQuery("select e from Producto e WHERE e.categoria= :cat");
        q03.setParameter("cat", c); 
        return q03.getResultList();
	} 
	
	public List<Producto> getCart(){
		// TODO: Probablemente no funcione, pero es un ejemplo de HQL vs SQL.
		// Accedemos a los objetos en lugar de las columnas
		UsuarioController ctrl = new UsuarioController();
		Usuario user = ctrl.get(1);
		
		
		String query = "SELECT c.amount, pv.name as variante, p.name as producto, c1.name as categoria"
				+ " FROM Usuario u "
				+ "	INNER JOIN cart c ON ( u.id = c.id_user  )  "
				+ "	INNER JOIN ProductoVariante pv ON ( c.producto = pv  )  "
				+ "	INNER JOIN Producto p ON ( pv.producto = p  )  "
				+ "	INNER JOIN Categoria c1 ON ( p.categoria = c1  ) "
				+ " WHERE u = :usuario";
		
		Query querySQL = entityManager.createQuery(query);
		
		querySQL.setParameter("usuario", user);
		
		return querySQL.getResultList();
	}

}

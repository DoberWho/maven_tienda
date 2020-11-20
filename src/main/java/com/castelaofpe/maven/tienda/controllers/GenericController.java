package com.castelaofpe.maven.tienda.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.castelaofpe.maven.tienda.models.Categoria;
import com.castelaofpe.maven.tienda.models.Persona;

public abstract class GenericController<T> {
	 
	  static final EntityManager entityManager = getManager();
	 private static EntityTransaction trans;
	
	  abstract T get(int id);
	  abstract List<T> getAll(); 
	  	  
	  private static EntityManager getManager() {
		  EntityManagerFactory factory = Persistence.createEntityManagerFactory("UD01");
		  return factory.createEntityManager();
	  } 
	  
	  public EntityTransaction beginTransaction() {
		  trans = entityManager.getTransaction();
		  trans.begin();
		  return trans;
	  }
	  
	  public void commit() {
		  trans.commit();
	  }
	  

		public void save(T t) { 
			entityManager.persist(t);  
		}


		public void update(T t) {  
			entityManager.persist(t);  			
		}


		public void delete(T t) { 
			entityManager.remove(t);  
		}
 
}

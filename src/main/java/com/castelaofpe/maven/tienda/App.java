package com.castelaofpe.maven.tienda;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.castelaofpe.maven.tienda.controllers.CategoriaController;
import com.castelaofpe.maven.tienda.controllers.ProductoController;
import com.castelaofpe.maven.tienda.controllers.ProductoVariantController;
import com.castelaofpe.maven.tienda.controllers.TagController;
import com.castelaofpe.maven.tienda.controllers.UsuarioController;
import com.castelaofpe.maven.tienda.models.Carrito;
import com.castelaofpe.maven.tienda.models.Categoria;
import com.castelaofpe.maven.tienda.models.Persona;
import com.castelaofpe.maven.tienda.models.Producto;
import com.castelaofpe.maven.tienda.models.Usuario;
import com.castelaofpe.maven.tienda.models.ProductoVariante;
import com.castelaofpe.maven.tienda.models.Tag;
import com.castelaofpe.maven.tienda.controllers.CarritoController;

/**
 * Hello world!
 *
 */
public class App {
	 
	
    public static void main( String[] args ) {    	
    	
    	CategoriaController catCtrl = new CategoriaController();
    	ProductoController prodCtrl = new ProductoController();
    	ProductoVariantController pVariantCtrl = new ProductoVariantController();
    	CarritoController cartCtrl = new CarritoController();
    	UsuarioController userCtrl = new UsuarioController();
    	TagController tagCtrl = new TagController();
    	 
    	Tag tag = tagCtrl.get(1); 
    	List<Producto> productos = tag.productos;
    	
    	for (Producto producto : productos) {
    		System.out.println(producto);   
    		List<Tag> tags = producto.etiquetas;
    		for (Tag tagItem : tags) {
    			System.out.println(tagItem);   
			}
		} 
    	
    }
}

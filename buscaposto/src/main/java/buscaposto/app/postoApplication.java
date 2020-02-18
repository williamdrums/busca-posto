package buscaposto.app;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import buscaposto.model.BuscaPosto;
import buscaposto.rest.BuscaPostoResource;
import buscaposto.rest.GerenteResource;
import buscaposto.rest.LoginResource;
//import buscaposto.rest.PostoResource;
import buscaposto.rest.UsuarioResource;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/ws")
public class postoApplication extends Application {

	
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();

		classes.add(UsuarioResource.class);
     	classes.add(BuscaPostoResource.class);
		classes.add(GerenteResource.class);
		classes.add(LoginResource.class);
		
	
		return classes;
	}
}

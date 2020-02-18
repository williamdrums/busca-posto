package buscaposto.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import buscaposto.bo.LoginBO;
import buscaposto.dao.LoginDAO;
import buscaposto.model.Usuario;

@Path("/login")
public class LoginResource {

	LoginDAO loginDAO = new LoginDAO();
	@POST
	@Path("/usuario")
	@Consumes("application/json")
	@Produces("application/json")
	public Response loginUsuario(Usuario usuario) {
//		return Response.status(200).entity(usuarioBO.listar()).build();
			System.out.println(usuario.getEmail());
			System.out.println(usuario.getSenha());
		Usuario usu = loginDAO.login(usuario);
	
		
		return Response.status(200).entity(usu)
				. header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.build();
//		return Response.ok("").entity(usu).header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//				.header("Access-Control-Max-Age", "2000").build();
	}

	
}

package buscaposto.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import buscaposto.bo.UsuarioBO;
import buscaposto.model.Usuario;

@Path("/usuario")
public class UsuarioResource {

	@Inject
	UsuarioBO usuarioBO = new UsuarioBO();

	@POST
	@Path("/salvar")
	@Consumes("application/json")
	@Produces("application/json")
	public Response salvar(Usuario usuario) {
		usuarioBO.salvar(usuario);
		//System.out.println( "test");
		//System.out.println("Entrou na Api"+usuario.toString());
		
		return Response.status(200).
				 header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.build();
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public Response listar() {
//		return Response.status(200).entity(usuarioBO.listar()).build();

		return Response.ok("").entity(usuarioBO.listar()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "2000").build();
	}

	@PUT
   @Consumes("application/json")
   @Produces("application/json")
	@Path("/editar/{id}")
	public Response editar(@PathParam("id") int id,Usuario usuario) {
		
		usuario.setId(id);
//		return Response.status(200).entity(usuarioBO.editar(id)).build();
		Usuario usuarioUpdate = usuarioBO.editar(id);
		usuarioUpdate.setEmail(usuario.getEmail());
		usuarioUpdate.setNome(usuario.getNome());
		usuarioUpdate.setSenha(usuario.getSenha());
		usuarioBO.salvar(usuarioUpdate);
		return Response.ok("").entity(usuarioBO.editar(id)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "2000").build();
	}

	@DELETE
	@Consumes("application/json")
    @Produces("application/json")
	@Path("/excluir/{id}")
	public void excluir(@PathParam("id") int id) {
		usuarioBO.remover(id);
	}

}

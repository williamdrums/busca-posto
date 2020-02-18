package buscaposto.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import buscaposto.bo.BuscaPostoBO;
import buscaposto.model.BuscaPosto;

@Path("/buscaposto")
public class BuscaPostoResource {

	@Inject
	BuscaPostoBO buscaPostoBO = new BuscaPostoBO();

	@POST
	@Path("/salvar")
	@Consumes("application/json")
	@Produces("application/json")
	public Response salvar(BuscaPosto buscaPosto) {
		buscaPostoBO.salvar(buscaPosto);
		//return Response.status(200).entity(buscaPosto).build();
		

		 return Response.ok("").header("Access-Control-Allow-Origin", "*")
		.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
		.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
		.header("Access-Control-Max-Age", "2000").build();
	}
	@GET
	@Path("/listar")
	@Produces("application/json")
	public Response listar() {
//		return Response.status(200).entity(buscaPostoBO.listar()).build();
		
		return Response.ok("").entity(buscaPostoBO.listar()).
				 header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "2000") 
				.build();
	}

	@GET
	@Path("/editar/{id}")
	public Response editar(@PathParam("id") int id) {
		return Response.status(200).entity(buscaPostoBO.editar(id)).build();
	}

	@DELETE
	@Path("/excluir/{id}")
	public void excluir(@PathParam("id") int id) {
		buscaPostoBO.remover(id);
	}
}

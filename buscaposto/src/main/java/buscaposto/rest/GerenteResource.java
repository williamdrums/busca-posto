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

import buscaposto.bo.GerenteBO;
import buscaposto.model.Gerente;


@Path("/gerente")
public class GerenteResource {

	@Inject
	GerenteBO gerenteBO = new GerenteBO();
	
	@POST
	@Path("/salvar")
	@Consumes("application/json")
	@Produces("application/json")
	public Response salvar(Gerente gerente) {
		gerenteBO.salvar(gerente);
		//return Response.status(200).entity(gerente).build();
		
		return Response.status(200).
				 header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.build();
		

//		 return Response.ok("").header("Access-Control-Allow-Origin", "*")
//		.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//		.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//		.header("Access-Control-Max-Age", "2000").build();
	}
	

	@GET
	@Path("/listar")
	@Produces("application/json")
	public Response listar() {
//		return Response.status(200).entity(gerenteBO.listar()).build();
		
		return Response.ok("").entity(gerenteBO.listar()).
				 header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "2000").build();
	}
	@GET
	@Path("/editar/{id}")
	public Response editar(@PathParam("id") int id) {
		return Response.status(200).entity(gerenteBO.editar(id)).build();
	}
	@DELETE
	@Path("/excluir/{id}")
	public void excluir(@PathParam("id") int id) {
		gerenteBO.remover(id);
	}
}

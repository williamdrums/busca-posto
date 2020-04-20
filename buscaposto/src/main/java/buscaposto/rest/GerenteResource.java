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

		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public Response listar() {

		return Response.ok("").entity(gerenteBO.listar()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "2000").build();
	}

	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/editar/{id}")
	public Response editar(@PathParam("id") int id, Gerente gerente) {

		gerente.setId(id);

		Gerente gerenteUpdate = gerenteBO.editar(id);
		gerenteUpdate.setEmail(gerente.getEmail());
		gerenteUpdate.setNome(gerente.getNome());
		gerenteUpdate.setSenha(gerente.getSenha());
		gerenteUpdate.setTelefone(gerente.getTelefone());
		gerenteBO.salvar(gerenteUpdate);

		return Response.ok("").entity(gerenteBO.editar(id)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "2000").build();

	}

	@DELETE
	@Path("/excluir/{id}")
	public void excluir(@PathParam("id") int id) {
		gerenteBO.remover(id);
	}
}

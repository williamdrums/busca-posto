package buscaposto.bo;

import java.util.List;

import javax.enterprise.context.Dependent;

import buscaposto.dao.GerenteDAO;

import buscaposto.model.Gerente;


@Dependent
public class GerenteBO {

	private GerenteDAO gerenteDAO = new GerenteDAO();

	public GerenteBO() {
	}

//	public void salvar(Gerente gerente) {
//		try {
//			gerenteDAO.salvar(gerente);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
	
	 public boolean salvar(Gerente gerente) {
	        try {
	        	return gerenteDAO.salvar(gerente);
	        } catch (Exception e) {
	            System.out.println(e);
	            return false;
	        }
	    }

	public List<Gerente> listar() {
		return gerenteDAO.buscarTodos();
	}

	public void remover(int id) {
		gerenteDAO.excluir(gerenteDAO.buscarPorId(id));
	}

	public Gerente editar(int id) {
		return gerenteDAO.buscarPorId(id);
	}
}

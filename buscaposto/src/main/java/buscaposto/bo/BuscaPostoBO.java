package buscaposto.bo;

import java.util.List;

import buscaposto.dao.BuscaPostoDAO;
import buscaposto.model.BuscaPosto;

public class BuscaPostoBO {

	private BuscaPostoDAO buscaPostoDAO = new BuscaPostoDAO();

	public BuscaPostoBO() {
	}

	public void salvar(BuscaPosto buscaPosto) {
		try {
			buscaPostoDAO.salvar(buscaPosto);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<BuscaPosto> listar() {
		return buscaPostoDAO.buscarTodos();
	}

	public void remover(int id) {
		buscaPostoDAO.excluir(buscaPostoDAO.buscarPorId(id));
	}

	public BuscaPosto editar(int id) {
		return buscaPostoDAO.buscarPorId(id);
	}
}

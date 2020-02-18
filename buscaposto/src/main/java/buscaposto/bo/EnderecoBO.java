package buscaposto.bo;

import java.util.List;

import buscaposto.dao.EnderecoDAO;
import buscaposto.model.Endereco;

public class EnderecoBO {

	private EnderecoDAO endDAO = new EnderecoDAO();

	public EnderecoBO() {
	}

	public void salvar(Endereco end) {
		try {
			endDAO.salvar(end);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<Endereco> listar() {
		return endDAO.buscarTodos();
	}

	public void remover(int id) {
		endDAO.excluir(endDAO.buscarPorId(id));
	}

	public Endereco editar(int id) {
		return endDAO.buscarPorId(id);
	}
}

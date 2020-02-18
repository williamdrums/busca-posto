package buscaposto.bo;

import java.util.List;

import javax.enterprise.context.Dependent;
import buscaposto.dao.UsuarioDAO;
import buscaposto.model.Usuario;

@Dependent
public class UsuarioBO {

	private UsuarioDAO usuDAO = new UsuarioDAO();

	public UsuarioBO() {
	}

//	public void salvar(Usuario usuario) {
//
//
//		try {
//			usuDAO.salvar(usuario);
//		} catch (Exception e) {
//			System.out.println(e);
//
//		}
//	}

    public boolean salvar(Usuario usuario) {
        try {
        	return usuDAO.salvar(usuario);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

	public List<Usuario> listar() {
		return usuDAO.buscarTodos();
	}

	public void remover(int id) {
		usuDAO.excluir(usuDAO.buscarPorId(id));
	}


	public Usuario editar(Integer id) {	
		return  usuDAO.buscarPorId(id);
	}

}

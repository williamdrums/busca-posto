//package buscaposto.bo;
//
//import java.util.List;
//
//import javax.enterprise.context.Dependent;
//
//import buscaposto.dao.PostoDAO;
//import buscaposto.model.Posto;
//
//@Dependent
//public class PostoBO {
//
//	
//	private PostoDAO postoDAO = new PostoDAO();
//
//
//    public PostoBO() {
//    }
//
//    public void salvar(Posto posto) {
//        try {
//        	postoDAO.salvar(posto);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public List<Posto> listar() {
//        return postoDAO.buscarTodos();
//    }
//
//    public void remover(int id) {
//    	postoDAO.excluir(postoDAO.buscarPorId(id));
//    }
//
//    public Posto editar(int id) {
//        return postoDAO.buscarPorId(id);
//    }
//}

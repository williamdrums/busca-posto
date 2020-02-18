//package buscaposto.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
//
//import buscaposto.model.Posto;
//
//
//
//public class PostoDAO {
//
//	EntityManagerFactory emf;
//	EntityManager meneger;
//	
//	public PostoDAO() {
//		// Ler o persistence.xml
//		emf = Persistence.createEntityManagerFactory("buscapostoPU");
//		// criando EntityManager
//		meneger = emf.createEntityManager();
//	}
//	
//	public void salvar(Posto posto) {
//		EntityTransaction tx = meneger.getTransaction();
//		tx.begin();
//		meneger.merge(posto);
//		tx.commit();
//
//	}
//	
//	public Posto buscarPorId(Integer id) {
//
//		return meneger.find(Posto.class, id);
//	}
//
//	public List<Posto> buscarTodos() {
//		// Query consulta = meneger.createQuery("select u from usuario u");
//		Query consulta = meneger.createNamedQuery("Posto.findAll");
//		return consulta.getResultList();
//	}
//	
//	public void excluir(Posto posto) {
//		try {
//			meneger.getTransaction().begin();
//			meneger.remove(posto);
//			meneger.getTransaction().commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//			meneger.getTransaction().rollback();
//			e.printStackTrace();
//		}
//
//	}
//}

package buscaposto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import buscaposto.model.BuscaPosto;

public class BuscaPostoDAO {

	EntityManagerFactory emf;
	EntityManager meneger;
	
	public BuscaPostoDAO() {
		
		emf = Persistence.createEntityManagerFactory("buscapostoPU");
		
		meneger = emf.createEntityManager();
	}
	
	public void salvar(BuscaPosto buscaPosto) {
		EntityTransaction tx = meneger.getTransaction();
		tx.begin();
		meneger.merge(buscaPosto);
		tx.commit();

	}
	public BuscaPosto buscarPorId(Integer id) {

		return meneger.find(BuscaPosto.class, id);
	}
	public List<BuscaPosto> buscarTodos() {
		
		Query consulta = meneger.createNamedQuery("BuscaPosto.findAll");
		return consulta.getResultList();
	}
	public void excluir(BuscaPosto buscaPosto) {
		try {
			meneger.getTransaction().begin();
			meneger.remove(buscaPosto);
			meneger.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			meneger.getTransaction().rollback();
			e.printStackTrace();
		}

	}
}

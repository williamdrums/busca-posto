package buscaposto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import buscaposto.model.Endereco;

public class EnderecoDAO {

	EntityManagerFactory emf;
	EntityManager meneger;

	public EnderecoDAO() {

		emf = Persistence.createEntityManagerFactory("buscapostoPU");

		meneger = emf.createEntityManager();
	}

	public void salvar(Endereco end) {
		EntityTransaction tx = meneger.getTransaction();
		tx.begin();
		meneger.merge(end);
		tx.commit();

	}

	public Endereco buscarPorId(Integer id) {

		return meneger.find(Endereco.class, id);
	}

	public List<Endereco> buscarTodos() {

		Query consulta = meneger.createNamedQuery("Endereco.findAll");
		return consulta.getResultList();
	}

	public void excluir(Endereco end) {
		try {
			meneger.getTransaction().begin();
			meneger.remove(end);
			meneger.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			meneger.getTransaction().rollback();
			e.printStackTrace();
		}

	}
}

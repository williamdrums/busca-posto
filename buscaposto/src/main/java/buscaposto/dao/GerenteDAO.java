package buscaposto.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import buscaposto.model.Gerente;
import buscaposto.model.Usuario;

public class GerenteDAO {

	EntityManagerFactory emf;
	EntityManager meneger;

	public GerenteDAO() {
		// Ler o persistence.xml
		emf = Persistence.createEntityManagerFactory("buscapostoPU");
		// Criano EntityManager
		meneger = emf.createEntityManager();
	}

//	public void salvar(Gerente gerente) {
//		EntityTransaction tx = meneger.getTransaction();
//		tx.begin();
//		meneger.merge(gerente);
//		tx.commit();
//
//	}

	public boolean salvar(Gerente gerente) {
		boolean resp = false;
		gerente.setSenha(md5(gerente.getSenha()));
		try {
			EntityTransaction tx = meneger.getTransaction();
			tx.begin();
			meneger.merge(gerente);
			tx.commit();
			resp = true;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return resp;

	}

	public Gerente buscarPorId(Integer id) {

		return meneger.find(Gerente.class, id);
	}

	public List<Gerente> buscarTodos() {
		Query consulta = meneger.createNamedQuery("Gerente.findAll");
		return consulta.getResultList();
	}

	public void excluir(Gerente gerente) {
		try {
			meneger.getTransaction().begin();
			meneger.remove(gerente);
			meneger.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			meneger.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	public String md5(String senha) {
		String sen = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		sen = hash.toString(16);
		return sen;
	}
}

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

import buscaposto.model.Usuario;
import buscaposto.util.JPAUtil;

public class UsuarioDAO {
	EntityManagerFactory emf;
	EntityManager meneger;

	public UsuarioDAO() {

		emf = Persistence.createEntityManagerFactory("buscapostoPU");

		meneger = emf.createEntityManager();
	}

	public boolean salvar(Usuario usuario) {
		boolean resp = false;
		usuario.setSenha(md5(usuario.getSenha()));
		try {
			EntityTransaction tx = meneger.getTransaction();
			tx.begin();
			meneger.merge(usuario);
			tx.commit();
			resp = true;

		} catch (Exception e) {

		}
		return resp;

	}

	public Usuario buscarPorId(Integer id) {

		return meneger.find(Usuario.class, id);
	}

	public List<Usuario> buscarTodos() {

		Query consulta = meneger.createQuery("select u from Usuario u ORDER BY u.id");

		return consulta.getResultList();
	}

	public void excluir(Usuario usuario) {
		try {
			meneger.getTransaction().begin();
			meneger.remove(usuario);
			meneger.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			meneger.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	// criptografa a senha pro banco
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

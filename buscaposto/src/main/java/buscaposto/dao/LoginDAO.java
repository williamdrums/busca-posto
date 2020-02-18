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

public class LoginDAO {

	EntityManagerFactory emf;
	EntityManager meneger;

	public LoginDAO() {

		emf = Persistence.createEntityManagerFactory("buscapostoPU");

		meneger = emf.createEntityManager();
	}

	public Usuario login(Usuario usuario) {

		usuario.setSenha(md5(usuario.getSenha()));
		Usuario user = null;
		try {

			Query consulta = meneger.createNamedQuery("Usuario.login");
					consulta.setParameter("email", usuario.getEmail());
					consulta.setParameter("senha", usuario.getSenha());
			user = (Usuario) consulta.getSingleResult();
	
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return user;

	}

	public Usuario buscarPorId(Integer id) {

		return meneger.find(Usuario.class, id);
	}

	public List<Usuario> buscarTodos() {
		// Query consulta = meneger.createQuery("select u from usuario u");
		Query consulta = meneger.createQuery("select u from Usuario u ORDER BY u.id");
		// Query consulta = meneger.createNamedQuery("Usuario.findAll");
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

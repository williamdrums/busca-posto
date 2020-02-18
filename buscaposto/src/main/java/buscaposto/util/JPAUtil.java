package buscaposto.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//public class JPAUtil {
//
//	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("buscapostoPU");
//
//	public EntityManager getEntityManager() {
//		return entityManagerFactory.createEntityManager();
//	}
//}
public class JPAUtil {

    private static final EntityManagerFactory emf;
    private static final EntityManager em;

    static {
        emf = Persistence.createEntityManagerFactory("buscapostoPU");
        em = emf.createEntityManager();
    }

    public static EntityManager abreConexao() {
        return em;
    }
}
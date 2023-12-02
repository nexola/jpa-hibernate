package aplicacao;

import model.dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(null, "Marcos", "marcos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Maria", "maria@gmail.com");
        Pessoa p3 = new Pessoa(null, "Amanda", "amanda@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); // Nome criado no persistence.xml
        EntityManager em = emf.createEntityManager();

        // Persistindo objetos no banco de dados || CREATE
        em.getTransaction().begin();
//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);

        // Recuperando um objeto || READ
        Pessoa p = em.find(Pessoa.class, 1);
        // Removendo um objeto || DELETE
//        em.remove(p);
        System.out.println(p);

        em.getTransaction().commit();

        em.close();
        emf.close();



    }
}

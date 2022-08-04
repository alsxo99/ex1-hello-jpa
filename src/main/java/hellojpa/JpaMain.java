package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member1 = new Member();
            Member member2 = new Member();
            Member member3 = new Member();

            member1.setUsername("A");
            member2.setUsername("B");
            member3.setUsername("C");

            System.out.println("=================");
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            System.out.println("=================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

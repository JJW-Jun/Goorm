package jpql;

import jpql.item.Child;
import jpql.item.Parent;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class JpaMain {
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpql");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            

            Member memberA = new Member();
            memberA.setMembername("memberA");
            em.persist(memberA);

            em.flush();
            em.clear();

            System.out.println("====================");
            Member refMember = em.getReference(Member.class, memberA.getId());
            System.out.println(refMember.getClass());
            em.close();
            System.out.println("====================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}


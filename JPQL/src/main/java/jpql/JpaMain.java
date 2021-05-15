package jpql;

import jpql.item.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaMain {
    public static void main(String args[]) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpql");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setMembername("memberA");
            em.persist(member);

            Member member2 = new Member();
            member2.setMembername("memberB");
            em.persist(member2);
            em.flush();
            em.clear();

            Member findMember = em.getReference(Member.class, member.getId());
            Member findMember2 = em.getReference(Member.class, member2.getId());
            System.out.println("====================");
            System.out.println("getClass= " + findMember.getClass());
            System.out.println("id= " + findMember.getId());
            System.out.println("id= " + findMember2.getId());
            System.out.println("username= " + findMember.getMembername());
            System.out.println(findMember.getClass()+"/ "+findMember2.getClass());
            System.out.println(findMember.getClass()==findMember2.getClass());
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
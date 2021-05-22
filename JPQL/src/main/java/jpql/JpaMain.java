package jpql;

//import jpql.item.Child;

import jpql.item.Parent;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class JpaMain {
    public static void main(String args[]) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpql");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setMembername("memberA");
            member.setAge(30);
            em.persist(member);

            // JAva 표준 스펙
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = criteriaBuilder.createQuery(Member.class);

            Root<Member> m = query.from(Member.class);
            CriteriaQuery<Member> criteriaQuery = query.select(m).where(criteriaBuilder.equal(
                    m.get("membername"), "memberA"
            ));


            String membername = "kim";
            if (membername != null) {
                criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(m.get("membername"), "memberA"));
            }

            List<Member> members = em.createQuery(criteriaQuery).getResultList();

            System.out.println("====================");
            for (Member mem : members) {
                System.out.println("Member= " + mem);
            }
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



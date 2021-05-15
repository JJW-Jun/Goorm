package jpql;

import jpql.item.Item;

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
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Team teamB = new Team();
            teamB.setName("teamA");
            em.persist(teamB);

            Member member = new Member();
            member.setMembername("memberA");
            member.setTeam(team);
            em.persist(member);

            Member member2 = new Member();
            member2.setMembername("memberB");
            member2.setTeam(teamB);
            em.persist(member2);


            em.flush();
            em.clear();
            System.out.println("====================");
            List<Member> members= em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();
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
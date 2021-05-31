package jpql;


import jpql.item.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static jpql.MemberType.USER;

//public class JpaMain {
//    public static void main(String args[]) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpql");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        try {
//            Team teamA = new Team();
//            teamA.setName("teamA");
//            em.persist(teamA);
//            Team teamB = new Team();
//            teamB.setName("teamB");
//            em.persist(teamB);
//            Member membeA = new Member();
//            membeA.setMembername("memberA");
//            membeA.setAge(10);
//            membeA.setTeam(teamA);
//            membeA.setType(MemberType.USER);
//            em.persist(membeA);
//            Member memberA2 = new Member();
//            memberA2.setMembername("memberB");
//            memberA2.setAge(20);
//            memberA2.setTeam(teamA);
//            memberA2.setType(MemberType.USER);
//            em.persist(memberA2);
//            Member memberB = new Member();
//            memberB.setMembername("memberB");
//            memberB.setAge(30);
//            memberB.setTeam(teamB);
//            memberB.setType(MemberType.USER);
//            em.persist(memberB);
//            em.flush();
//            em.clear();
//            String query = "select m From Member m";
//            List<Member> result = em.createQuery(query, Member.class).getResultList();
//            System.out.println("====================");
//            for (Member member : result) {
//                System.out.println("member= " + member.getMembername() + ", " + member.getTeam().getName());
//            }
//            System.out.println("====================");
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();
//    }
//}

public class JpaMain {
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpql");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member memberA = new Member();
            memberA.setMembername("memberA");
            memberA.setAge(10);
            memberA.setTeam(teamA);
            memberA.setType(USER);
            em.persist(memberA);

            Member memberB = new Member();
            memberB.setMembername("memberB");
            memberB.setAge(20);
            memberB.setTeam(teamA);
            memberB.setType(USER);
            em.persist(memberB);

            Member memberC = new Member();
            memberC.setMembername("memberC");
            memberC.setAge(30);
            memberC.setTeam(teamB);
            memberC.setType(USER);
            em.persist(memberC);




            em.createQuery("update Member m set m.age = 80 where m.type =:USER")
                    .setParameter("USER", USER)
                    .executeUpdate();

            em.clear();
            System.out.println("====================");
            Member findMember = em.find(Member.class, 1L);
            System.out.println("Age= "+findMember.getAge());
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





package jpql;

import javax.persistence.*;
import java.util.List;

import jpql.MemberDto;

public class JpaMain {
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpql");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // dbConnection 얻어와서 쿼리 날리는 법.
        try {
            Member member = new Member();
            member.setUsername("memberC");
            member.setAge(20);
            em.persist(member);

            TypedQuery<Member> query = em.createQuery("select m from Member m where m.id = 1", Member.class);
            Member result = query.getSingleResult();

            System.out.println("====================");
            System.out.println("result= " + result);
            System.out.println("====================");
//            for (int i = 1; i <= 5; i++) {
//                Team team = new Team();
//                team.setName("team-"+i);
//                em.persist(team);
//
//                Member member = new Member();
//                member.setUsername("member-" + i);
//                member.setTeam(team);
//                member.setAge(i);
//
//
//                em.persist(member);
//            }
//
//            String query3 = "select m from Member m left join Team t on m.username = t.name";
//            List<Member> result = em.createQuery(query3, Member.class)
//                    .getResultList();
//            System.out.println("====================");
//            result.stream().forEach(System.out::println);
//            System.out.println("====================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

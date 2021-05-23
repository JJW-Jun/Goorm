package jpql;


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
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setMembername("memberA");
//            member.setTeam(team);
            em.persist(member);
//            Team teamA = new Team();
//            teamA.setName("teamA");
//            em.persist(teamA);
//
//            Team teamB = new Team();
//            teamB.setName("teamB");
//            em.persist(teamB);

//            Member memberA = new Member();
//            memberA.setMembername("memberA");
//            memberA.setAge(30);
//            memberA.setType(MemberType.ADMIN);
//            em.persist(memberA);

//            Member memberB = new Member();
//            memberB.setMembername("memberB");
//            memberB.setAge(30);
//            memberB.setType(MemberType.USER);
//            memberB.setTeam(teamB);
//            em.persist(memberB);


            System.out.println("====================");
            System.out.println(em.find(Member.class, 1L));
//            String query = "select m.membername from Member m where m.type= jpql.MemberType.ADMIN";
//            List<Object[]> result = em.createQuery(query).getResultList();
//            System.out.println("Member= "+result.get(0));
            System.out.println("====================");

        } catch (Exception e) {
            e.printStackTrace();

            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

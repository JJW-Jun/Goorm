import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
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

            Member membeA = new Member();
            membeA.setUsername("memberA");
            membeA.setAge(10);
            membeA.setTeam(teamA);
            membeA.setType(MemberType.USER);
            em.persist(membeA);

            Member memberB = new Member();
            memberB.setUsername("memberB");
            memberB.setAge(20);
            memberB.setTeam(teamA);
            memberB.setType(MemberType.USER);
            em.persist(memberB);

            Member memberC = new Member();
            memberC.setUsername("memberC");
            memberC.setAge(30);
            memberC.setTeam(teamB);
            memberC.setType(MemberType.USER);
            em.persist(memberC);

            em.flush();
            em.clear();
            
            String query = "select m From Member m where m = :member";
            Member findMember = em.createQuery(query, Member.class)
                    .setParameter("member", memberB)
                    .getSingleResult();

            System.out.println("====================");

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

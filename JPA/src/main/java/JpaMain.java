import javax.persistence.*;

public class JpaMain {
    public static void main(String args[]) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member memberA = new Member();
            memberA.setUsername("memberA");
            em.persist(memberA);

            Member memberB = new Member();
            memberB.setUsername("memberB");
            em.persist(memberB);
            em.flush();
            em.clear();

            System.out.println("====================");
            Member refMember = em.getReference(Member.class, memberB.getId());
            em.detach(refMember);
            refMember.getUsername();
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

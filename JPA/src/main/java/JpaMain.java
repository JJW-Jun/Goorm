import javax.persistence.*;

public class JpaMain {
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setId(1L);
            member.setMemberName("A");
            member.setRoleType(RoleType.USER);
            em.persist(member);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}

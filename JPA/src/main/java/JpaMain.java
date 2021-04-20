import javax.persistence.*;

public class JpaMain {
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        // 여러 서버가 있어도 동시성 이슈 없이 사용가능하다. 미리 50개 만큼의 공간을 할당한 후 사용한다. 메모리 1씩 먹으면서 50개
        try {
            Member memberA = new Member();
            memberA.setMemberName("A");
            memberA.setRoleType(RoleType.USER);

            Member memberB = new Member();
            memberB.setMemberName("B");
            memberB.setRoleType(RoleType.USER);

            Member memberC = new Member();
            memberC.setMemberName("C");
            memberC.setRoleType(RoleType.USER);
            System.out.println("====================");
            em.persist(memberA);
            em.persist(memberB);
            em.persist(memberC);
            System.out.println("====================");
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}

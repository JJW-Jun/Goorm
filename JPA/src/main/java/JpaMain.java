import javax.persistence.*;

public class JpaMain {
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setName("MemberA");
            member.setTeamId(team.getId());
            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
// 여러 서버가 있어도 동시성 이슈 없이 사용가능하다. 미리 50개 만큼의 공간을 할당한 후 사용한다. 메모리 1씩 먹으면서 50개
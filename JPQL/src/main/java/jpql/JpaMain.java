package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

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
            // 쿼리만으로는
            // zjffpr션은 데이터가 없기 때문에 쿼리문이 나갔다. 그러나 fetch 로 바꾸면안 ㅏㄴㄴ간다
            String query = "select t From Team t";
            List<Team> result = em.createQuery(query, Team.class)
                    .setFirstResult(0)
                    .setMaxResults(2)
                    .getResultList();

            System.out.println(result.size());
            System.out.println("====================");
            for(Team team :result){
                System.out.println("팀= "+team.getName()+ ", 회원수="+ team.getMembers().size());
                for(Member member : team.getMembers()){
                    System.out.println("->member= "+member);
                }
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


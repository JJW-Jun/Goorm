//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import java.util.List;
//
//public class JpaMain {
//    public static void main(String args[]) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try {
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("memberA");
//            member.setTeam(team);
//            em.persist(member);
////            team.getMembers().add(member);
//
//            // 이걸 하면 문제가 없다.
//            em.flush();
//            em.clear();
//            // 순수한 객체상태. 1차캐시에는 있지만 데이터베이스에는 없다. 조회
//            // 테스트케이스에도 이상하게 나온다.
//            Team findTeam = em.find(Team.class, team.getId());  // 1차 캐시 - 메모리에 있다.
//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findTeam.getMembers(); // 근데 여기는 값이 없다.
//            System.out.println("====================");
//            for (Member m : members) {
//                System.out.println("m= " + m.getUsername());
////                System.out.println(m);
//                // ZJSON생성 라이브리도 그렇다.
//                // ㅇ렌티티를 컨트롤러로 리스폰스로가면 엔티티를 제이슨으로바꿀때 양방향에서 무한오류가 난다.롬복 투스트링 빼고 써라
//                // JSON생성 라이브러리는걱정 x.  컨트롤러는 엔티티를 절대 반환하지마라. 1.무한루프, 2.엔티티변경가능->근데 aapi스펙이 바뀜
//                //
//            }
//            System.out.println("====================");
//
//            // dudthr성 있는거 db에 다 날려서 동기화
//            // ㅡ무ㅛ새one은 eager가 디폴트
//            // em.clear()
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();
//    }
//}
//// 여러 서버가 있어도 동시성 이슈 없이 사용가능하다. 미리 50개 만큼의 공간을 할당한 후 사용한다. 메모리 1씩 먹으면서 50개
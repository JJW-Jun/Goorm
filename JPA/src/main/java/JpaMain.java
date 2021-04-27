import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMain {
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // dbConnection 얻어와서 쿼리 날리는 법.
        try {
            System.out.println("====================");
            String sql = "select MEMBER_ID, USERNAME from Member";
            em.createNativeQuery(sql)
                    .getResultList().forEach(System.out::println);
            System.out.println("====================");
//            List<Member> result =
//                    em.createQuery("select m From Member m where m.username like '%memberA'",
//                            Member.class)
//                            .getResultList();
//            System.out.println("====================");
//            result.stream().forEach(System.out::println);
//            System.out.println("====================");

//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//            Root<Member> m = query.from(Member.class);
//
//            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "memberA"));
//            List<Member> results = em.createQuery(cq).getResultList();
//            results.stream().forEach(System.out::println);

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
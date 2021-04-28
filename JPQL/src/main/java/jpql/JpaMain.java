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
            member.setType(MemberType.ADMIN);
            em.persist(member);

            String query = "select case when m.age<=10 then '학생요금' when m.age>=60 then '경로요금' else '일반요금' end from Member m";
            String query2 = "select nullif(m.username, '관리자') as Member from Member m";
            String query3 = "select coalesce(m.username, '이름 없는 회원') from Member m";
            List<String> result = em.createQuery(query3, String.class).getResultList();
            System.out.println("====================");
            result.stream().forEach(System.out::println);
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

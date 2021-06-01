package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import jpql.item.Company;

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

            Company companyA = new Company();
            companyA.setName("companyA");
            em.persist(companyA);

            Family familyA = new Family();
            familyA.setName("familyA");
            em.persist(familyA);

            Company companyC = new Company();
            companyC.setName("companyC");
            em.persist(companyC);


            Member memberA = new Member();
            memberA.setMembername("memberA");
            memberA.setAge(10);
            memberA.setTeam(teamA);
            memberA.setCompany(companyA);
            memberA.setFamily(familyA);
            memberA.setType(MemberType.USER);
            em.persist(memberA);

//            Member memberA2 = new Member();
//            memberA2.setMembername("memberB");
//            memberA2.setAge(20);
//            memberA2.setTeam(teamA);
//            memberA.setCompany(companyA);
//            memberA2.setType(MemberType.USER);
//            em.persist(memberA2);
//
//            Member memberB = new Member();
//            memberB.setMembername("memberB");
//            memberB.setAge(30);
//            memberB.setTeam(teamB);
//            memberB.setType(MemberType.USER);
//            em.persist(memberB);
//
//            Member memberC = new Member();
//            memberC.setMembername("memberB");
//            memberC.setAge(40);
//            memberC.setTeam(teamB);
//            memberC.setCompany(companyC);
//            memberC.setType(MemberType.USER);
//            em.persist(memberC);

            em.flush();
            em.clear();
            String query = "select m From Member m where m.id=1";
//            List<Member> result = em.createQuery(query, Member.class).getResultList();
            Member findMember = em.createQuery(query, Member.class).getSingleResult();
            System.out.println("====================");
            System.out.println("member= " + findMember);
//            System.out.println("team= " + member.getTeam());
//            System.out.println("company= " + member.getCompany());
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

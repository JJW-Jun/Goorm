import javax.persistence.*;

public class JpaMain {

    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            
            Address address = new Address("Busan", "streetB", "051");
            Member memberA = new Member();
            memberA.setUsername("memberA");
            memberA.setOfficeAddress(address);
            memberA.setPeriod(new Period());
            em.persist(memberA);

            Address newAddress = new Address("Seoul", "streetB", "051");
            Member memberB = new Member();
            memberB.setUsername("memberB");
            memberB.setOfficeAddress(newAddress);
            memberB.setPeriod(new Period());
            em.persist(memberB);



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

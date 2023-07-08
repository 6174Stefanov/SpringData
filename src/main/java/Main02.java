import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main02 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<String> query = em.createQuery("SELECT e.firstName FROM Employee e" +
                        " WHERE e.salary > 50000",
                String.class)
                .getResultList();

        System.out.println(String.join("\n", query));

        em.getTransaction().commit();
        em.close();
    }
}
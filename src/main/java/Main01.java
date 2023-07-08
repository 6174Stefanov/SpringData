import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Scanner scanner = new Scanner(System.in);
        String[] searchedName = scanner.nextLine().split(" ");

        Long isInDB = em.createQuery("SELECT COUNT(e) FROM Employee e" +
                                " WHERE e.firstName = :first_name" +
                                " and e.lastName = :last_name",
                        Long.class)
                .setParameter("first_name", searchedName[0])
                .setParameter("last_name", searchedName[1])
                .getSingleResult();

        if (isInDB > 0){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        em.getTransaction().commit();
    }
}

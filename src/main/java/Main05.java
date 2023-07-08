import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);


        em.createQuery("FROM Address a" +
                                " order by a.employees.size desc",
                        Address.class)
                        .setMaxResults(10)
                        .getResultStream()
                        .forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
    }
}

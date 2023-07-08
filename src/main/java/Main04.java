import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        String addressText = "Vitoshka 15";
        Address address = new Address();
        address.setText(addressText);
        em.persist(address);
        Employee employee = em.createQuery("SELECT e FROM Employee e" +
                                " where  e.lastName = :name",
                        Employee.class)
                .setParameter("name", lastName)
                .getSingleResult();


        employee.setAddress(address);
        em.persist(employee);
        em.getTransaction().commit();
        em.close();
    }
}
